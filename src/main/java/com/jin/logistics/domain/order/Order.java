package com.jin.logistics.domain.order;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.agency.Agency;
import com.jin.logistics.domain.type.OrderStatus;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "agency_code")
  private Agency agency;
  @NotNull
  private LocalDate orderDate;
  @NotNull
  private LocalDate shippingDate;
  @NotNull
  @Size(max = 30)
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus = OrderStatus.PENDING;
  @NotNull
  private int totalQuantity;
  @NotNull
  private long totalSupplyPrice;
  @NotNull
  private float totalVat;
  @NotNull
  private long totalAmount;
  @Size(max = 3000)
  private String notes;
}
