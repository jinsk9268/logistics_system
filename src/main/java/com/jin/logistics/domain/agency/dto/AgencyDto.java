package com.jin.logistics.domain.agency.dto;

import com.jin.logistics.domain.agency.entity.Agency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AgencyDto {
  @NotBlank
  @Size(max = 30)
  private String code;
  @NotBlank
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
  @NotBlank
  @Size(max = 10)
  private String businessNumber;
  @NotNull
  @Size(max = 30)
  private String contact;
  @NotNull
  @Size(max = 1000)
  private String shippingAddress;
  private long creditLimit;

  public Agency toEntity() {
    return Agency.builder()
        .code(code)
        .password(password)
        .agencyName(agencyName)
        .email(email)
        .ceoName(ceoName)
        .businessNumber(businessNumber)
        .contact(contact)
        .shippingAddress(shippingAddress)
        .creditLimit(creditLimit)
        .build();
  }

  public static AgencyDto fromEntity(Agency agency) {
    return AgencyDto.builder()
        .code(agency.getCode())
        .password(agency.getPassword())
        .agencyName(agency.getAgencyName())
        .email(agency.getEmail())
        .ceoName(agency.getCeoName())
        .businessNumber(agency.getBusinessNumber())
        .contact(agency.getContact())
        .shippingAddress(agency.getShippingAddress())
        .creditLimit(agency.getCreditLimit())
        .build();
  }
}