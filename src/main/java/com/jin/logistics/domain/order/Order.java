package com.jin.logistics.domain.order;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.agency.Agency;
import com.jin.logistics.domain.type.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Order extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "agency_code")
  private Agency agency;
  @Column(nullable = false)
  private LocalDate orderDate;
  @Column(nullable = false)
  private LocalDate shippingDate;
  @Column(nullable = false, length = 30)
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus = OrderStatus.PENDING;
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
