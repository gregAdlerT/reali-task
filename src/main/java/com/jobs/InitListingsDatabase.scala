package com.jobs

import com.model.Listing
import com.repository.ListingsRepository
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import scala.io.Source

/**
 * @author Greg Adler
 */
@Component
class InitListingsDatabase(@Value("${file.url}")
                           val fileUrl: String, flatRepository: ListingsRepository) extends CommandLineRunner{
  
  override def run(args: String*): Unit = {
    downloadData()
  }

  def downloadData(): Unit = {
    val source = Source.fromURL(fileUrl)
    val csv = source.getLines().toList
    source.close()
    val res = csv.tail.map {
      case s"$id,$street,$status,$price,$bedrooms,$bathrooms,$sq_ft,$lat,$lng" => Right(Listing(id.toLong,
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
      case Left(x) => println(x) //todo: logger
    }
  }
}
