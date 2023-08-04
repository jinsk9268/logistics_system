package com.jin.logistics.domain.order.dto;

import com.jin.logistics.domain.order.entity.Order;
import com.jin.logistics.domain.order.entity.OrderDetail;
import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.util.DetailCompositeKey;
import com.jin.logistics.util.PriceCalculator;
import com.jin.logistics.util.VatCalculator;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderDetailDto {

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Request {
    private int quantity;
    private long productSupplyPrice;
    @NotNull
    private BigDecimal productVat;

    public Request(int quantity, Product product) {
      this.quantity = quantity;
      this.productSupplyPrice = PriceCalculator.calProductSupplyPrice(quantity, product.getBoxSupplyPrice());
      this.productVat = VatCalculator.multiplyIntWithVat(quantity, product.getBoxVat());
    }

    public OrderDetail toEntity(Order order, Product product) {
      return OrderDetail.builder()
          .id(new DetailCompositeKey(order.getId(), product.getCode()))
          .order(order)
          .product(product)
          .quantity(quantity)
          .productSupplyPrice(productSupplyPrice)
          .productVat(productVat)
          .productTotalAmount(PriceCalculator.calTotalPrice(productSupplyPrice, productVat))
          .build();
    }
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Response {

    private Long orderId;
    private String agencyCode;
    private String agencyName;
    private String productCode;
    private String productName;
    private int quantity;
    private long productSupplyPrice;
    private BigDecimal productVat;
    private long productTotalAmount;

    public static OrderDetailDto.Response from(OrderDetail orderDetail) {
      return OrderDetailDto.Response.builder()
          .orderId(orderDetail.getOrder().getId())
          .agencyCode(orderDetail.getOrder().getAgency().getCode())
          .agencyName(orderDetail.getOrder().getAgency().getAgencyName())
          .productCode(orderDetail.getProduct().getCode())
          .productName(orderDetail.getProduct().getName())
          .quantity(orderDetail.getQuantity())
          .productSupplyPrice(orderDetail.getProductSupplyPrice())
          .productVat(orderDetail.getProductVat())
          .productTotalAmount(orderDetail.getProductTotalAmount())
          .build();
    }
  }
}