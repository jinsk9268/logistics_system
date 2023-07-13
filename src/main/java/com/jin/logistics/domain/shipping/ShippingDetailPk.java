package com.jin.logistics.domain.shipping;


import com.jin.logistics.domain.product.Product;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShippingDetailPk implements Serializable {

  @EqualsAndHashCode.Include
  private Shipping shipping;
  @EqualsAndHashCode.Include
  private Product product;
}
