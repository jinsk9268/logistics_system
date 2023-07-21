package com.jin.logistics.domain.product.dto;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.product.entity.ProductStockTx;
import com.jin.logistics.domain.type.StockChange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductStockTxDto {
  // TODO: 2023/07/21 대리점 정보 추가에 생각해보기 (변경기록 방법에 대해...)

  @NotNull
  private Long id;
  @NotBlank
  private String productCode;
  @NotBlank
  private String name;
  @NotBlank
  @Size(max = 30)
  private StockChange stockChange;
  private int quantity;
  @Size(max = 3000)
  private String notes;


  public static ProductStockTxDto fromEntity(ProductStockTx productStockTx) {
    return ProductStockTxDto.builder()
        .id(productStockTx.getId())
        .productCode(productStockTx.getProduct().getCode())
        .name(productStockTx.getProduct().getName())
        .stockChange(productStockTx.getStockChange())
        .quantity(productStockTx.getQuantity())
        .notes(Optional.ofNullable(productStockTx.getNotes()).orElse(""))
        .build();
  }
}