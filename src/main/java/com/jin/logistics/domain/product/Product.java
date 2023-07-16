package com.jin.logistics.domain.product;

import com.jin.logistics.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
  private float vat;
  @Column(nullable = false)
  private int boxQuantity;
  @Column(length = 3000)
  private String description;
  @Column(length = 30)
  private String manufacturer;
}
