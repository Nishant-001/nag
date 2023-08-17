package com.ecommerce.services.order;

import com.ecommerce.dto.OrderDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.responce.GeneralResponse;

import java.util.List;

public interface OrderService {

    List<ProductDto> searchProductByTitle(String title);

    GeneralResponse addOrderProduct(OrderDto orderDto);

    List<OrderDto> getMyOrdersByUserId(Long userId);

    List<ProductDto> getAllProducts();
}
