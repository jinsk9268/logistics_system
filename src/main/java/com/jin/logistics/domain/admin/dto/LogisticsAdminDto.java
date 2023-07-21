package com.jin.logistics.domain.admin.dto;

import com.jin.logistics.domain.admin.entity.LogisticsAdmin;
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
public class LogisticsAdminDto {

  @NotBlank
  @Size(max = 30)
  private String code;
  @NotBlank
  @Size(max = 30)
  private String id;
  @NotNull
  @Size(max = 100)
  private String password;
  @NotNull
  @Size(max = 30)
  private String name;
  @NotNull
  @Size(max = 11)
  private String mobile;

  public LogisticsAdmin toEntity() {
    return LogisticsAdmin.builder()
        .code(code)
        .id(id)
        .password(password)
        .name(name)
        .mobile(mobile)
        .build();
  }

  public static LogisticsAdminDto fromEntity(LogisticsAdmin logisticsAdmin) {
    return LogisticsAdminDto.builder()
        .code(logisticsAdmin.getCode())
        .id(logisticsAdmin.getId())
        .password(logisticsAdmin.getPassword())
        .name(logisticsAdmin.getName())
        .mobile(logisticsAdmin.getMobile())
        .build();
  }
}