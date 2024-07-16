package com.example.glovo2.mapper;

import com.example.glovo2.dto.ItemDTO;
import com.example.glovo2.entity.ItemEntity;

public class ItemMapper {

    public static ItemDTO toDTO(ItemEntity itemEntity) {
        return ItemDTO.builder()
                .id(itemEntity.getId())
                .quantity(itemEntity.getQuantity())
                .build();
    }

    public static ItemEntity toEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(itemDTO.getId())
                .quantity(itemDTO.getQuantity())
                .build();
    }
}
