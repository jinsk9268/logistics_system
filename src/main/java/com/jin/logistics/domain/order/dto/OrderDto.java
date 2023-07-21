package com.jin.logistics.domain.order.dto;

import com.jin.logistics.domain.agency.entity.Agency;
import com.jin.logistics.domain.order.entity.Order;
import com.jin.logistics.domain.type.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OrderDto {

  @NotNull
  private Long id;
  @NotNull
  private String agencyCode;
  @NotNull
  private LocalDate orderDate;
  @NotNull
  private LocalDate shippingDate;
  @NotNull
  @Size(max = 30)
  private OrderStatus orderStatus = OrderStatus.PENDING;
  private int totalQuantity;
  private long totalSupplyPrice;
  @NotNull
  private BigDecimal totalVat;
  private long totalAmount;
  @Size(max = 3000)
  private String notes;

  public Order toEntity(Agency agency) {
    return Order.builder()
        .agency(agency)
        .orderDate(orderDate)
        .shippingDate(shippingDate)
        .orderStatus(orderStatus)
        .totalQuantity(totalQuantity)
        .totalSupplyPrice(totalSupplyPrice)
        .totalVat(totalVat)
        .totalAmount(totalAmount)
        .notes(notes)
        .build();
  }

  public static OrderDto fromEntity(Order order) {
    return OrderDto.builder()
        .id(order.getId())
        .agencyCode(order.getAgency().getCode())
        .orderDate(order.getOrderDate())
        .shippingDate(order.getShippingDate())
        .orderStatus(order.getOrderStatus())
        .totalQuantity(order.getTotalQuantity())
        .totalSupplyPrice(order.getTotalSupplyPrice())
        .totalVat(order.getTotalVat())
        .totalAmount(order.getTotalAmount())
        .notes(order.getNotes() == null ? "" : order.getNotes())
        .build();
  }
}