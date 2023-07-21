package com.jin.logistics.domain.product.entity;

import com.jin.logistics.domain.util.BaseEntity;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductStock extends BaseEntity {

  @Id
  private String productCode;
  @OneToOne(optional = false)
  @JoinColumn(name = "product_code")
  @MapsId
  private Product product;
  @Column(nullable = false)
  private int quantity;
}
