package com.repository

import com.model.Listing
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Greg Adler
 */
trait ListingRepository extends JpaRepository[Listing, Long]{
def findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(priceFrom: Long,
                                                            priceTo: Long,
                                                            bedroomFrom: Int,
                                                            bedroomTo: Int,
                                                            bathroomFrom: Int,
                                                            bathroomTo: Int,
                                                            pageable: Pageable):Page[Listing]
}
