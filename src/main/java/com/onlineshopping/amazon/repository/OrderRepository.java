package com.onlineshopping.amazon.repository;

import com.onlineshopping.amazon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
 public List<Order> findByCustomerCustomerId(int cid);
}
