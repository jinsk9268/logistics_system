package com.jin.logistics.domain.agency.entity;

import com.jin.logistics.domain.util.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Agency extends BaseEntity {

  @Id
  @Column(length = 30)
  private String code;
  @Column(nullable = false, length = 100)
  private String password;
  @Column(nullable = false, length = 30)
  private String agencyName;
  @Column(nullable = false, length = 50)
  private String email;
  @Column(nullable = false, length = 30)
  private String ceoName;
  @Column(nullable = false, length = 10)
  private String businessNumber;
  @Column(nullable = false, length = 30)
  private String contact;
  @Column(nullable = false, length = 1000)
  private String shippingAddress;
  @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0")
  private long creditLimit;

  public void changeCreditLimit(long credit) {
    creditLimit += credit;
  }
}
