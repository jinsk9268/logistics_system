package com.jin.logistics.domain.order.entity;

import com.jin.logistics.domain.agency.entity.Agency;
import com.jin.logistics.domain.type.OrderStatus;
import com.jin.logistics.domain.util.BaseEntity;
import com.jin.logistics.util.PriceCalculator;
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
  @Column(nullable = false, length = 30, columnDefinition = "VARCHAR(30) DEFAULT 'PENDING'")
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;
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

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderDetail> orderDetails = new ArrayList<>();

  public void updateQuantityAndPrice(List<OrderDetail> orderDetails) {
    this.totalQuantity = PriceCalculator.calTotalQuantityFromEntity(orderDetails);
    this.totalSupplyPrice = PriceCalculator.calTotalSupplyPriceFromEntity(orderDetails);
    this.totalVat = PriceCalculator.calTotalVatFromEntity(orderDetails);
    this.totalAmount = PriceCalculator.calTotalAmount(this.totalSupplyPrice, this.totalVat);
  }
}
