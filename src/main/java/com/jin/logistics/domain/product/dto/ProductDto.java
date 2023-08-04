package com.jin.logistics.domain.product.dto;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.util.PriceCalculator;
import com.jin.logistics.util.VatCalculator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Optional;

public class ProductDto {
  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Request {

    @NotBlank
    @Size(max = 30)
    private String code;
    @NotBlank
    @Size(max = 30)
    private String name;
    private boolean isTaxExemption;
    private int supplyPrice;
    private int boxQuantity;
    @Size(max = 3000)
    private String description;

    public Product toEntity() {
      BigDecimal vat = VatCalculator.calVat(isTaxExemption, supplyPrice);

      return Product.builder()
          .code(code)
          .name(name)
          .supplyPrice(supplyPrice)
          .vat(vat)
          .boxQuantity(boxQuantity)
          .boxSupplyPrice(PriceCalculator.calBoxSupplyPrice(boxQuantity, supplyPrice))
          .boxVat(VatCalculator.multiplyIntWithVat(boxQuantity, vat))
          .description(description)
          .build();
    }
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Response {

    private String code;
    private String name;
    private boolean isTaxExemption;
    private int supplyPrice;
    private BigDecimal vat;
    private int boxQuantity;
    private int boxSupplyPrice;
    private BigDecimal boxVat;
    private String description;

    public static ProductDto.Response from(Product product) {
      return Response.builder()
          .code(product.getCode())
          .name(product.getName())
          .isTaxExemption(product.getVat().equals(BigDecimal.ZERO))
          .supplyPrice(product.getSupplyPrice())
          .vat(product.getVat())
          .boxQuantity(product.getBoxQuantity())
          .boxSupplyPrice(product.getBoxSupplyPrice())
          .boxVat(product.getBoxVat())
          .description(Optional.ofNullable(product.getDescription()).orElse(""))
          .build();
    }
  }
}