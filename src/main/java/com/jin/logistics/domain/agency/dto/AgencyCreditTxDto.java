package com.jin.logistics.domain.agency.dto;

import com.jin.logistics.domain.agency.entity.Agency;
import com.jin.logistics.domain.agency.entity.AgencyCreditTx;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AgencyCreditTxDto {
  private Long id;
  private String agencyCode;
  private long creditChange;
  @Builder.Default
  @Size(max = 3000)
  private String notes = "";

  public AgencyCreditTx toEntity(Agency agency) {
    return AgencyCreditTx.builder()
        .agency(agency)
        .creditChange(creditChange)
        .notes(notes)
        .build();
  }

  public static AgencyCreditTxDto fromEntity(AgencyCreditTx tx) {
    return AgencyCreditTxDto.builder()
        .id(tx.getId())
        .agencyCode(tx.getAgency().getCode())
        .creditChange(tx.getCreditChange())
        .notes(tx.getNotes())
        .build();
  }
}