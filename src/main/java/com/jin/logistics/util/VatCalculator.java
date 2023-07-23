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

  public static BigDecimal addVat(BigDecimal totalVat, BigDecimal vat, int quantity) {
    return totalVat.add(vat.multiply(BigDecimal.valueOf(quantity)));
  }

  public static long totalVatToLong(BigDecimal totalVat) {
    return totalVat.setScale(0, RoundingMode.HALF_UP).longValue();
  }
}
