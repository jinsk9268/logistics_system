package com.jin.logistics.domain.order.entity;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.util.DetailCompositeKey;
import com.jin.logistics.domain.util.DetailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDetail extends DetailEntity {

  @MapsId("id")
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;

  @Builder
  public OrderDetail(
      DetailCompositeKey id, Product product, int quantity, long productSupplyPrice,
      BigDecimal productVat, long productTotalAmount, Order order
  ) {
    super(id, product, quantity, productSupplyPrice, productVat, productTotalAmount);
    this.order = order;
  }
}
