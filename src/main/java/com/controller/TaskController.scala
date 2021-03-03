package com.controller

import com.model.Listing
import com.service.MyService
import org.geojson.GeoJsonObject
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

@RestController
class TaskController(val myService: MyService) {


  @GetMapping(value = Array("/listings"))
  def getListings(
               @RequestParam(value = "priceMax", defaultValue = "999999") priceMax: Long,
               @RequestParam(value = "priceMin", defaultValue = "0") priceMin: Long,
               @RequestParam(value = "bedroomsMin", defaultValue = "0") bedroomsMin: Int,
               @RequestParam(value = "bedroomsMax", defaultValue = "1000") bedroomsMax: Int,
               @RequestParam(value = "bathroomsMin", defaultValue = "0") bathroomMin: Int,
               @RequestParam(value = "bathroomsMax", defaultValue = "1000") bathroomMax: Int,
              ): GeoJsonObject= {
    myService getListingsGeoJSON (priceMax, priceMin, bedroomsMin, bedroomsMax, bathroomMin, bathroomMax)
  }



}
