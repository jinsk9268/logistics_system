package com.jin.logistics.domain.order;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@IdClass(OrderDetailPk.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDetail extends BaseEntity {

  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;
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
