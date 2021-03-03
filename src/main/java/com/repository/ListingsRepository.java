package com.repository;

import com.model.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface ListingsRepository extends JpaRepository<Listing, Long> {
    
    Stream<Listing> findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(Long priceFrom, Long priceTo, Integer bedroomFrom,
                                                                            Integer bedroomTo, Integer bathroomFrom,
                                                                            Integer bathroomTo);

}
