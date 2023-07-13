package com.jin.logistics.domain.order;

import com.jin.logistics.domain.product.Product;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDetailPk implements Serializable {

  @EqualsAndHashCode.Include
  private Order order;
  @EqualsAndHashCode.Include
  private Product product;
}
