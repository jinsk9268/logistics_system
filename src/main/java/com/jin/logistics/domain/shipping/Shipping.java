package com.jin.logistics.domain.shipping;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Shipping extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;
  @Column(nullable = false)
  private LocalDate shippingCompleteDate;
  @Column(nullable = false)
  private int totalQuantity;
  @Column(nullable = false)
  private long totalSupplyPrice;
  @Column(nullable = false)
  private float totalVat;
  @Column(nullable = false)
  private long totalAmount;
  @Column(length = 3000)
  private String notes;
}
