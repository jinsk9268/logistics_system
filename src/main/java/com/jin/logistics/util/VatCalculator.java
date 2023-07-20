package com.jin.logistics.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VatCalculator {

  public static final BigDecimal VAT_PER = new BigDecimal("0.1");

  public static BigDecimal calVat(boolean isTaxExemption, int supplyPrice) {
    return isTaxExemption
        ? BigDecimal.ZERO
        : VAT_PER.multiply(BigDecimal.valueOf(supplyPrice));
  }
}
