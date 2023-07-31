package com.jin.logistics.domain.product.dto;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.util.VatCalculator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductDto {

  @NotBlank
  @Size(max = 30)
  private String code;
  @NotBlank
  @Size(max = 30)
  private String name;
  private boolean isTaxExemption;
  private int supplyPrice;
  private BigDecimal vat;
  private int boxQuantity;
  private int boxSupplyPrice;
  private BigDecimal boxVat;
  @Size(max = 3000)
  private String description;
  @Size(max = 30)
  private String manufacturer;

  public Product toEntity() {
    return Product.builder()
        .code(code)
        .name(name)
        .supplyPrice(supplyPrice)
        .vat(VatCalculator.calVat(isTaxExemption, supplyPrice))
        .boxQuantity(boxQuantity)
        .boxSupplyPrice(supplyPrice * boxQuantity)
        .boxVat(VatCalculator.calVat(isTaxExemption, supplyPrice).multiply(BigDecimal.valueOf(boxQuantity)))
        .description(description)
        .build();
  }

  public static ProductDto fromEntity(Product product) {
    return ProductDto.builder()
        .code(product.getCode())
        .name(product.getName())
        .isTaxExemption(product.getVat().equals(BigDecimal.ZERO))
        .supplyPrice(product.getSupplyPrice())
        .vat(product.getVat())
        .boxQuantity(product.getBoxQuantity())
        .description(Optional.ofNullable(product.getDescription()).orElse(""))
        .build();
  }
}