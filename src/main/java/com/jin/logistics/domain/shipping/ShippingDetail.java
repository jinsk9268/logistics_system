package com.jin.logistics.domain.shipping;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(ShippingDetailPk.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ShippingDetail extends BaseEntity {

  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "shipping_id")
  private Shipping shipping;
  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @Column(nullable = false)
  private int quantity;
  @Column(nullable = false)
  private long productSupplyPrice;
  @Column(nullable = false)
  private float productVat;
  @Column(nullable = false)
  private long productTotalAmount;
}
