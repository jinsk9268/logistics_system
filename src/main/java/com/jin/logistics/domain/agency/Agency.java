package com.jin.logistics.domain.agency;

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
  @Column(nullable = false, length = 30)
  private String businessNumber;
  @Column(nullable = false, length = 30)
  private String contact;
  @Column(nullable = false, length = 1000)
  private String shippingAddress;
  @Column(nullable = false)
  private long creditLimit = 0;
}
