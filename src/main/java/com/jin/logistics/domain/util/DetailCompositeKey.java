package com.jin.logistics.domain.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class DetailCompositeKey implements Serializable {

  /**
   * Detail 내역에서 공통적으로 사용하는 복합키
   */
  private Long id;
  private String productCode;
}
