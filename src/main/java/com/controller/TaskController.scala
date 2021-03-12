package com.controller


import com.api.ApiConstantsAndDefaults
import com.service.ListingServiceImpl
import org.geojson.GeoJsonObject
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}
/**
 * @author Greg Adler
 */
@RestController
class TaskController(val listingService: ListingServiceImpl) {
  
  @GetMapping(value = Array(ApiConstantsAndDefaults.LISTINGS))
  def getListings(
                   @RequestParam(value = "page", defaultValue = ApiConstantsAndDefaults.PAGE) page: Int,
                   @RequestParam(value = "page_size", defaultValue = ApiConstantsAndDefaults.PAGE_SIZE) pageSize: Int,
                   @RequestParam(value = "min_price", defaultValue = ApiConstantsAndDefaults.MIN_PRICE) priceMin: Long,
                   @RequestParam(value = "max_price", defaultValue = ApiConstantsAndDefaults.MAX_PRICE) priceMax: Long,
                   @RequestParam(value = "min_bed", defaultValue = ApiConstantsAndDefaults.MIN_BED) bedroomsMin: Int,
                   @RequestParam(value = "max_bed", defaultValue = ApiConstantsAndDefaults.MAX_BED) bedroomsMax: Int,
                   @RequestParam(value = "min_bath", defaultValue = ApiConstantsAndDefaults.MIN_BATH) bathroomMin: Int,
                   @RequestParam(value = "max_bath", defaultValue = ApiConstantsAndDefaults.MAX_BATH) bathroomMax: Int,
                 ): GeoJsonObject =
    listingService.getListingsGeoJSON(page,pageSize, priceMin, priceMax, bedroomsMin, bedroomsMax, bathroomMin, bathroomMax)
}
