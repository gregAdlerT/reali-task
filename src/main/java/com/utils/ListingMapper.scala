package com.utils

import com.model.Listing
import org.geojson.{Feature, Point}

import scala.jdk.CollectionConverters._


/**
 * @author Greg Adler
 */
object ListingMapper {

  def listingToFeature(listing: Listing): Feature = {
    val feature = new Feature
    feature.setGeometry(new Point(listing.lng, listing.lat))

    val properties:Map[String, AnyRef]  = Map(
      "id" -> listing.id.toString,
      "price" -> listing.price.toString,
      "street" -> listing.street,
      "bedrooms" -> listing.bedrooms.toString,
      "bathrooms" -> listing.bathrooms.toString,
      "sq_ft" -> listing.sq_ft.toString,
    )
    feature.setProperties(properties.asJava)
    feature
  }
}
