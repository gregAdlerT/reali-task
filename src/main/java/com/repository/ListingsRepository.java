package com.repository;

import com.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingsRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(Long priceFrom, Long priceTo, Integer bedroomFrom,
                                                                          Integer bedroomTo, Integer bathroomFrom,
                                                                          Integer bathroomTo);

}
