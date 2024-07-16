package com.example.glovo2.service;

import com.example.glovo2.dto.ItemDTO;
import com.example.glovo2.dto.OrderDTO;
import com.example.glovo2.entity.ItemEntity;
import com.example.glovo2.entity.OrderEntity;
import com.example.glovo2.entity.ProductEntity;
import com.example.glovo2.mapper.ItemMapper;
import com.example.glovo2.mapper.OrderMapper;
import com.example.glovo2.repository.ItemRepository;
import com.example.glovo2.repository.OrderRepository;
import com.example.glovo2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private ItemRepository itemRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderMapper::toDTO).toList();
    }

    public OrderDTO save(OrderDTO orderDTO) {
        return OrderMapper.toDTO(orderRepository.save(OrderMapper.toEntity(orderDTO)));
    }

    public OrderDTO addItem(ItemDTO itemDTO, int orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        ItemEntity itemEntity  = ItemMapper.toEntity(itemDTO);
        ProductEntity productEntity = productRepository.findById(itemDTO.getProductId()).orElseThrow();
        itemEntity.setOrder(orderEntity);
        ProductEntity build = ProductEntity.builder().id(itemEntity.getProduct().getId()).build();
        itemEntity.setProduct(build);

    }
}
