package com.example.glovo2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO {
    private int id;
    private int productId;
    private int quantity;
}
