package com.jin.logistics.domain.shipping.dto;

import com.jin.logistics.domain.order.entity.Order;
import com.jin.logistics.domain.shipping.entity.Shipping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ShippingDto {

  @NotNull
  private Long id;
  @NotNull
  private Long orderId;
  @NotNull
  private LocalDate shippingCompleteDate;
  private int totalQuantity;
  private long totalSupplyPrice;
  @NotNull
  private BigDecimal totalVat;
  private long totalAmount;
  @Size(max = 3000)
  private String notes;

  public Shipping toEntity(Order order) {
    return Shipping.builder()
        .order(order)
        .shippingCompleteDate(shippingCompleteDate)
        .totalQuantity(totalQuantity)
        .totalSupplyPrice(totalSupplyPrice)
        .totalVat(totalVat)
        .totalAmount(totalAmount)
        .notes(notes)
        .build();
  }

  public static ShippingDto fromEntity(Shipping shipping) {
    return ShippingDto.builder()
        .id(shipping.getId())
        .orderId(shipping.getOrder().getId())
        .shippingCompleteDate(shipping.getShippingCompleteDate())
        .totalQuantity(shipping.getTotalQuantity())
        .totalSupplyPrice(shipping.getTotalSupplyPrice())
        .totalVat(shipping.getTotalVat())
        .totalAmount(shipping.getTotalAmount())
        .notes(shipping.getNotes() == null ? "" : shipping.getNotes())
        .build();
  }
}