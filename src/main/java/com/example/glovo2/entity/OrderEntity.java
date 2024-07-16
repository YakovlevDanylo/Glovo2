package com.example.glovo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private int id;
    private int orderNumber;
    @OneToMany(mappedBy = "ItemEntity")
    private List<ItemEntity> items;
}
