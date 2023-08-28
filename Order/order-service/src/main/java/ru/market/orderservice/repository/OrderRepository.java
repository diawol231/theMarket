package ru.market.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.market.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
