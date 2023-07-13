package com.jin.logistics.domain.admin;

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
public class LogisticsAdmin extends BaseEntity {

  @Id
  @Size(max = 30)
  private String code;
  @NotNull
  @Size(max = 30)
  private String id;
  @NotNull
  @Size(max = 100)
  private String password;
  @NotNull
  @Size(max = 30)
  private String name;
  @NotNull
  @Size(max = 30)
  private String mobile;
}
