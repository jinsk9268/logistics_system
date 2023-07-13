package com.jin.logistics.domain.agency;

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
public class Agency extends BaseEntity {

  @Id
  @Size(max = 30)
  private String code;
  @NotNull
  @Size(max = 100)
  private String password;
  @NotNull
  @Size(max = 30)
  private String agencyName;
  @NotNull
  @Size(max = 50)
  private String email;
  @NotNull
  @Size(max = 30)
  private String ceoName;
  @NotNull
  @Size(max = 30)
  private String businessNumber;
  @NotNull
  @Size(max = 30)
  private String contact;
  @NotNull
  @Size(max = 1000)
  private String shippingAddress;
  @NotNull
  private long creditLimit = 0;
}
