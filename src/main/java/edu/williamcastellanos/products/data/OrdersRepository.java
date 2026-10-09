package edu.williamcastellanos.products.data;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> {

}