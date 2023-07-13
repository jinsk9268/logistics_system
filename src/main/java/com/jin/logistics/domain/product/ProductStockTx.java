package com.jin.logistics.domain.product;

import com.jin.logistics.domain.BaseEntity;
import com.jin.logistics.domain.type.StockChange;
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
@Table(name = "product_stock_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductStockTx extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_code")
  private Product product;
  @NotNull
  @Size(max = 30)
  @Enumerated(EnumType.STRING)
  private StockChange stockChange;
  @Size(max = 3000)
  private String notes;
  @NotNull
  private int quantity;
}
