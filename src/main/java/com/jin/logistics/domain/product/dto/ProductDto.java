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
        .description(description)
        .manufacturer(manufacturer)
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
        .manufacturer(Optional.ofNullable(product.getManufacturer()).orElse(""))
        .build();
  }
}