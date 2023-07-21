package com.jin.logistics.domain.order.dto;

import com.jin.logistics.domain.order.entity.OrderDetail;
import com.jin.logistics.domain.util.DetailCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OrderDetailDto {

  @NotNull
  private Long orderId;
  @NotNull
  private String productCode;
  @NotNull
  private String name;
  private int quantity;
  private long productSupplyPrice;
  @NotNull
  private BigDecimal productVat;
  private long productTotalAmount;

  public OrderDetail toEntity() {
    return OrderDetail.builder()
        .id(new DetailCompositeKey(orderId, productCode))
        .quantity(quantity)
        .productSupplyPrice(productSupplyPrice)
        .productVat(productVat)
        .productTotalAmount(productTotalAmount)
        .build();
  }

  public static OrderDetailDto fromEntity(OrderDetail orderDetail) {
    return OrderDetailDto.builder()
        .orderId(orderDetail.getOrder().getId())
        .productCode(orderDetail.getProduct().getCode())
        .name(orderDetail.getProduct().getName())
        .quantity(orderDetail.getQuantity())
        .productSupplyPrice(orderDetail.getProductSupplyPrice())
        .productVat(orderDetail.getProductVat())
        .productTotalAmount(orderDetail.getProductTotalAmount())
        .build();
  }
}