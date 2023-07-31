package com.jin.logistics.domain.product.entity;

import com.jin.logistics.domain.util.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product extends BaseEntity {

  @Id
  @Column(length = 30)
  private String code;
  @Column(nullable = false, length = 30)
  private String name;
  @Column(nullable = false)
  private int supplyPrice;
  @Column(nullable = false)
  private BigDecimal vat;
  @Column(nullable = false)
  private int boxQuantity;
  @Column(nullable = false)
  private int boxSupplyPrice;
  @Column(nullable = false)
  private BigDecimal boxVat;
  @Column(length = 3000)
  private String description;
}
