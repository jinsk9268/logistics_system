package com.jin.logistics.util;

import java.math.BigDecimal;

public class PriceCalculator {

  public static int calBoxSupplyPrice(int boxQuantity, int supplyPrice) {
    return boxQuantity * supplyPrice;
  }

  public static long calProductSupplyPrice(int quantity, int supplyPrice) {
    return quantity * (long) supplyPrice;
  }

  public static long calTotalPrice(long productSupplyPrice, BigDecimal productVat) {
    return productSupplyPrice + VatCalculator.vatToLong(productVat);
  }
}
