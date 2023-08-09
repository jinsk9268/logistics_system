package com.jin.logistics.domain.util;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.util.PriceCalculator;
import com.jin.logistics.util.VatCalculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DetailEntity extends BaseEntity {

  @EmbeddedId
  private DetailCompositeKey id;
  @MapsId("productCode")
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @Column(nullable = false)
  private int quantity;
  @Column(nullable = false)
  private long productSupplyPrice;
  @Column(nullable = false, columnDefinition = "DECIMAL(10, 1) DEFAULT 0")
  private BigDecimal productVat;
  @Column(nullable = false)
  private long productTotalAmount;

  public void changeQuantity(int changeQuantity) {
    this.quantity = changeQuantity;
    this.productSupplyPrice = PriceCalculator.calProductSupplyPrice(changeQuantity, this.product.getBoxSupplyPrice());
    if (!this.productVat.equals(BigDecimal.ZERO)) {
      this.productVat = VatCalculator.multiplyIntWithVat(changeQuantity, this.product.getBoxVat());
    }

    this.productTotalAmount = PriceCalculator.calTotalAmount(this.productSupplyPrice, this.productVat);
  }
}
