package com.onlineshopping.amazon.repository;

import com.onlineshopping.amazon.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Integer> {
}
