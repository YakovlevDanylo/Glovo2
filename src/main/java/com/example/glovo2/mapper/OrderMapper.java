package com.example.glovo2.mapper;

import com.example.glovo2.dto.OrderDTO;

import com.example.glovo2.entity.ItemEntity;
import com.example.glovo2.entity.OrderEntity;

public class OrderMapper {

    public static OrderDTO toDTO(OrderEntity order) {
        return OrderDTO.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .itemsId(order.getItems().stream().map(ItemEntity::getId).toList())
                .build();
    }

    public static OrderEntity toEntity(OrderDTO dto) {
        return OrderEntity.builder()
                .id(dto.getId())
                .orderNumber(dto.getOrderNumber())
                .build();
    }
}
