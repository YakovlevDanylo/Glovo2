package com.example.glovo2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderDTO {
    private int id;
    private int orderNumber;
    private List<Integer> itemsId;
}
