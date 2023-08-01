package com.jin.logistics.domain.order.dto;

import com.jin.logistics.domain.agency.entity.Agency;
import com.jin.logistics.domain.order.entity.Order;
import com.jin.logistics.domain.type.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDto {
  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  public static class OrderItem {
    private String productCode;
    private int quantity;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Request {
    @NotBlank
    private String agencyCode;
    @NotNull
    private LocalDate orderDate;
    @NotNull
    private LocalDate shippingDate;
    @NotNull
    @Size(max = 30)
    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private List<OrderItem> orderItems = new ArrayList<>();
    @Size(max = 3000)
    private String notes;

    public Order toEntity(Agency agency) {
      return Order.builder()
          .agency(agency)
          .orderDate(orderDate)
          .shippingDate(shippingDate)
          .orderStatus(orderStatus)
          .totalVat(BigDecimal.ZERO)
          .notes(notes)
          .build();
    }
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Response {
    private Long id;
    private String agencyCode;
    private String agencyName;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private OrderStatus orderStatus;
    private int totalQuantity;
    private long totalSupplyPrice;
    private BigDecimal totalVat;
    private long totalAmount;
    private String notes;

    public static OrderDto.Response from(Order order) {
      return OrderDto.Response.builder()
          .id(order.getId())
          .agencyCode(order.getAgency().getCode())
          .agencyName(order.getAgency().getAgencyName())
          .orderDate(order.getOrderDate())
          .shippingDate(order.getShippingDate())
          .orderStatus(order.getOrderStatus())
          .totalQuantity(order.getTotalQuantity())
          .totalSupplyPrice(order.getTotalSupplyPrice())
          .totalVat(order.getTotalVat())
          .totalAmount(order.getTotalAmount())
          .notes(Optional.ofNullable(order.getNotes()).orElse(""))
          .build();
    }
  }
}