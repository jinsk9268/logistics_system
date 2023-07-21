package com.jin.logistics.domain.product.dto;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.product.entity.ProductStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductStockDto {

  private String productCode;
  private String name;
  private int quantity;

  public static ProductStockDto fromEntity(ProductStock productStock) {
    return ProductStockDto.builder()
        .productCode(productStock.getProductCode())
        .name(productStock.getProduct().getName())
        .quantity(productStock.getQuantity())
        .build();
  }
}