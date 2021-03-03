package com.service

import org.geojson.GeoJsonObject

/**
 * @author Greg Adler
 */
trait ListingService {
  def getListingsGeoJSON( priceMin: Long, priceMax: Long, bedroomsMin: Int, bedroomsMax: Int,
                          bathroomsMin: Int, bathroomsMax: Int): GeoJsonObject
}
