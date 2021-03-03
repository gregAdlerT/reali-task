package com.controller


import com.api.ApiConstants
import com.service.ListingServiceImpl
import org.geojson.GeoJsonObject
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}


@RestController
class TaskController(val myService: ListingServiceImpl) {

  @GetMapping(value = Array(ApiConstants.LISTINGS))
  def getListings(
                   @RequestParam(value = "page", defaultValue = "0") page: Int,
                   @RequestParam(value = "page_size", defaultValue = "100") pageSize: Int,
                   @RequestParam(value = "min_price", defaultValue = ApiConstants.MIN_PRICE) priceMin: Long,
                   @RequestParam(value = "max_price", defaultValue = ApiConstants.MAX_PRICE) priceMax: Long,
                   @RequestParam(value = "min_bed", defaultValue = ApiConstants.MIN_BED) bedroomsMin: Int,
                   @RequestParam(value = "max_bed", defaultValue = ApiConstants.MAX_BED) bedroomsMax: Int,
                   @RequestParam(value = "min_bath", defaultValue = ApiConstants.MIN_BATH) bathroomMin: Int,
                   @RequestParam(value = "max_bath", defaultValue = ApiConstants.MAX_BATH) bathroomMax: Int,
                 ): GeoJsonObject =
    myService.getListingsGeoJSON(page,pageSize, priceMin, priceMax, bedroomsMin, bedroomsMax, bathroomMin, bathroomMax)
}
