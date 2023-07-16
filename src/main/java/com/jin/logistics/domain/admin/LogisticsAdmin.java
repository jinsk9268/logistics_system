package com.jin.logistics.domain.admin;

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
public class LogisticsAdmin extends BaseEntity {

  @Id
  @Column(length = 30)
  private String code;
  @Column(nullable = false, unique = true, length = 30)
  private String id;
  @Column(nullable = false, length = 100)
  private String password;
  @Column(nullable = false, length = 30)
  private String name;
  @Column(nullable = false, length = 30)
  private String mobile;
}
