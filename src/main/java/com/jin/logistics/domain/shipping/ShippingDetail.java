package com.jin.logistics.domain.shipping;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.product.Product;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@IdClass(ShippingDetailPk.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShippingDetail extends BaseEntity {

  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "shipping_id")
  private Shipping shipping;
  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @NotNull
  private int quantity;
  @NotNull
  private long productSupplyPrice;
  @NotNull
  private float productVat;
  @NotNull
  private long productTotalAmount;
}
