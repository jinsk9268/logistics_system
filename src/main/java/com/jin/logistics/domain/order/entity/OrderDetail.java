package com.jin.logistics.domain.order.entity;

import com.jin.logistics.domain.product.entity.Product;
import com.jin.logistics.domain.util.BaseEntity;
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
public class OrderDetail extends BaseEntity {

  @EmbeddedId
  private DetailCompositeKey id;
  @MapsId("id")
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;
  @MapsId("productCode")
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @Column(nullable = false)
  private int quantity;
  @Column(nullable = false)
  private long productSupplyPrice;
  @Column(nullable = false)
  private BigDecimal productVat;
  @Column(nullable = false)
  private long productTotalAmount;
}
