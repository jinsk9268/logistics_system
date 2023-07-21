package com.jin.logistics.domain.product.entity;

import com.jin.logistics.domain.util.BaseEntity;
import com.jin.logistics.domain.type.StockChange;

import javax.persistence.*;

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
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @Column(nullable = false, length = 30)
  @Enumerated(EnumType.STRING)
  private StockChange stockChange;
  @Column(nullable = false)
  private int quantity;
  @Column(length = 3000)
  private String notes;
}
