package com.service

import java.util.stream.Collectors

import com.model.Listing
import com.repository.ListingsRepository
import org.geojson.{Feature, FeatureCollection, GeoJsonObject, Point}
import org.springframework.stereotype.Service

import scala.jdk.CollectionConverters._


@Service
class MyService(repository: ListingsRepository) {
  
  
  def getListingsGeoJSON( priceMax: Long, priceMin: Long, bedroomsMin: Int, bedroomsMax: Int,
                          bathroomsMin: Int, bathroomsMax: Int): GeoJsonObject = {
    val listings = getFlats(priceMax, priceMin, bedroomsMin, bedroomsMax, bathroomsMin, bathroomsMax)

    val featuresList: java.util.List[Feature] = listings
      .map(listingToFeature)
      .collect(Collectors.toList())
    
    val features = new FeatureCollection
    features.setFeatures(featuresList)
    
    features
  }

  def getFlats( priceMax: Long, priceMin: Long, bedroomsMin: Int, bedroomsMax: Int,
               bathroomsMin: Int, bathroomsMax: Int): java.util.stream.Stream[Listing]= repository.findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(priceMin, priceMax, bedroomsMin,
      bedroomsMax, bathroomsMin, bathroomsMax)


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
