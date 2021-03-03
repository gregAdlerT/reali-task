package com.controller

import com.model.Listing
import com.service.MyService
import org.geojson.GeoJsonObject
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

@RestController
class TaskController(val myService: MyService) {


  @GetMapping(value = Array("/listings"))
  def getListings(
               @RequestParam(value = "max_price", defaultValue = "999999") priceMax: Long,
               @RequestParam(value = "min_price", defaultValue = "0") priceMin: Long,
               @RequestParam(value = "min_bed", defaultValue = "0") bedroomsMin: Int,
               @RequestParam(value = "max_bed", defaultValue = "1000") bedroomsMax: Int,
               @RequestParam(value = "min_bath", defaultValue = "0") bathroomMin: Int,
               @RequestParam(value = "max_bath", defaultValue = "1000") bathroomMax: Int,
              ): GeoJsonObject= {
    myService getListingsGeoJSON (priceMax, priceMin, bedroomsMin, bedroomsMax, bathroomMin, bathroomMax)
  }



}
