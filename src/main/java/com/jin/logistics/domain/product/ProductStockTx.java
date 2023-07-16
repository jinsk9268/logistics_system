package com.jin.logistics.domain.product;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.type.StockChange;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_stock_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductStockTx extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @Column(nullable = false, length = 30)
  @Enumerated(EnumType.STRING)
  private StockChange stockChange;
  @Column(length = 3000)
  private String notes;
  @Column(nullable = false)
  private int quantity;
}
