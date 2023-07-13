package com.jin.logistics.domain.order;

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
  @NotNull
  private int quantity;
  @NotNull
  private long productSupplyPrice;
  @NotNull
  private float productVat;
  @NotNull
  private long productTotalAmount;
}
