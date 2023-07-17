package com.jin.logistics.domain.agency.entity;

import com.jin.logistics.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "agency_credit_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AgencyCreditTx extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "agency_code")
  private Agency agency;
  @Column(nullable = false)
  private long creditChange;
  @Column(length = 3000)
  private String notes;
}
