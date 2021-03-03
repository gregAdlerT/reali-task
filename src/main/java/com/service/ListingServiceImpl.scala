package com.service

import java.util.stream.Collectors

import com.repository.ListingsRepository
import com.utils.ListingMapper
import org.geojson.{Feature, FeatureCollection, GeoJsonObject}
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class ListingServiceImpl(repository: ListingsRepository) extends ListingService {

  override def getListingsGeoJSON(page:Int,pageSize:Int,
                                  priceMin: Long,
                                  priceMax: Long,
                                  bedroomsMin: Int,
                                  bedroomsMax: Int,
                                  bathroomsMin: Int,
                                  bathroomsMax: Int): GeoJsonObject = {
    val pageable = PageRequest.of(page, pageSize)
    val listings = repository.findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(priceMin,
      priceMax,
      bedroomsMin,
      bedroomsMax,
      bathroomsMin,
      bathroomsMax,
      pageable)

    val featuresList: java.util.List[Feature] = listings
      .stream()
      .map(ListingMapper.listingToFeature)
      .collect(Collectors.toList())

    val features = new FeatureCollection
    features.setFeatures(featuresList)
    features
  }
  
}
