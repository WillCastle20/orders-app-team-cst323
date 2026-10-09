package edu.williamcastellanos.products.mapper;

import edu.williamcastellanos.products.data.OrderEntity;
import edu.williamcastellanos.products.models.OrdersModel;

public class OrderMapper {

    public static OrdersModel toModel(OrderEntity entity) {
        return new OrdersModel(
            entity.getId(),
            entity.getOrderNumber(),
            entity.getProductName(),
            entity.getPrice(),
            entity.getQty()
        );
    }

    public static OrderEntity toEntity(OrdersModel model) {
        return new OrderEntity(
            model.getId(),
            model.getOrderNumber(),
            model.getProductName(),
            model.getPrice(),
            model.getQty()
        );
    }
}