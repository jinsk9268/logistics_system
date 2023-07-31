package com.jin.logistics.domain.shipping.entity;

import com.jin.logistics.domain.util.BaseEntity;
import com.jin.logistics.domain.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
  @Column(nullable = false, columnDefinition = "DECIMAL(10, 1) DEFAULT 0")
  private BigDecimal totalVat;
  @Column(nullable = false)
  private long totalAmount;
  @Column(length = 3000)
  private String notes;

  @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ShippingDetail> shippingDetails = new ArrayList<>();
}
