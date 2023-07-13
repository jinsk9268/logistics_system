package com.jin.logistics.domain.shipping;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.order.Order;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Shipping extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;
  @NotNull
  private LocalDate shippingCompleteDate;
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
