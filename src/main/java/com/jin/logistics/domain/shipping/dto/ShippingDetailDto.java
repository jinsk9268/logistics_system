package com.jin.logistics.domain.shipping.dto;

import com.jin.logistics.domain.shipping.entity.ShippingDetail;
import com.jin.logistics.domain.util.DetailCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ShippingDetailDto {

  @NotNull
  private Long shippingId;
  @NotBlank
  private String productCode;
  @NotBlank
  private String name;
  private int quantity;
  private long productSupplyPrice;
  @NotNull
  private BigDecimal productVat;
  private long productTotalAmount;

  public ShippingDetail toEntity() {
    return ShippingDetail.builder()
        .id(new DetailCompositeKey(shippingId, productCode))
        .quantity(quantity)
        .productSupplyPrice(productSupplyPrice)
        .productVat(productVat)
        .productTotalAmount(productTotalAmount)
        .build();
  }
}