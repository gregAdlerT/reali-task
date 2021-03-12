package com.service

import java.util.stream.Collectors

import com.model.Listing
import com.repository.ListingRepository
import com.utils.ListingMapper
import org.geojson.{Feature, FeatureCollection, GeoJsonObject}
import org.springframework.data.domain.{Page, PageRequest}
import org.springframework.stereotype.Service
/**
 * @author Greg Adler
 */
@Service
class ListingServiceImpl(repository: ListingRepository) extends ListingService {

  override def getListingsGeoJSON(page:Int,
                                  pageSize:Int,
                                  priceMin: Long,
                                  priceMax: Long,
                                  bedroomsMin: Int,
                                  bedroomsMax: Int,
                                  bathroomsMin: Int,
                                  bathroomsMax: Int): GeoJsonObject = {
    val pageable = PageRequest.of(page, pageSize)
    val listings:Page[Listing] = repository.findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(priceMin,
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
