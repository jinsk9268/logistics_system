package com.jin.logistics.domain.product;

import com.jin.logistics.domain.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product extends BaseEntity {

  @Id
  @Size(max = 30)
  private String code;
  @NotNull
  @Size(max = 30)
  private String name;
  @NotNull
  private int supplyPrice;
  @NotNull
  private float vat;
  @NotNull
  private int boxQuantity;
  @Size(max = 3000)
  private String description;
  @Size(max = 30)
  private String manufacturer;
}
