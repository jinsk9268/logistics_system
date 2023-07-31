package com.jin.logistics.domain.shipping.entity;

import com.jin.logistics.domain.util.BaseEntity;
import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.util.DetailCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ShippingDetail extends BaseEntity {

  @EmbeddedId
  private DetailCompositeKey id;
  @MapsId("id")
  @ManyToOne(optional = false)
  @JoinColumn(name = "shipping_id")
  private Shipping shipping;
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
}
