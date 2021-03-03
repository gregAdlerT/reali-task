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

    val properties:Map[String, Any]  = Map(
      "id" -> listing.id,
      "price" -> listing.price,
      "street" -> listing.street,
      "bedrooms" -> listing.bedrooms,
      "bathrooms" -> listing.bathrooms,
      "sq_ft" -> listing.sq_ft,
    )
    feature.setProperties(properties.asJava)
    feature
  }
}
