package com.jobs

import com.model.Listing
import com.repository.ListingRepository
import org.apache.logging.log4j.scala.Logging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

import scala.io.Source

/**
 * @author Greg Adler
 */
@Component
class InitListingsDatabase(@Value("${file.url}")
                           val fileUrl: String, flatRepository: ListingRepository) extends CommandLineRunner with Logging {
  
  override def run(args: String*): Unit = {
    downloadData()
  }

  def downloadData(): Unit = {
    val source = Source.fromURL(fileUrl)
    val csv = source.getLines().toList
    source.close()
    val res = csv.tail.map {
      case s"$id,$street,$status,$price,$bedrooms,$bathrooms,$sq_ft,$lat,$lng" => Right( Listing(id.toLong,
        street,
        status,
        price.toLong,
        bedrooms.toInt,
        bathrooms.toInt,
        sq_ft.toInt,
        lat.toDouble,
        lng.toDouble))
      case line => Left(s"Cannot read '$line'")
    }
    res.map {
      case Right(x) => flatRepository.save(x)
      case Left(x) =>logger.warn(s"Unable to parse listing $x")
    }
//    val listing =  new Listing(0,null, null, 10, 0, 0, 0, 0, 0)
//    listing.setStreet("aaaaaaaaaa")
//    listing.setId(99999L)
//    flatRepository.save(listing)
//    listing.setStreet("bbbbbbbbbb")
//    listing.street_=("bb")
//    flatRepository
//      .findById(99999L)
//      .map(_.getStreet)
//      .ifPresent(println)
  }
}
