package com.jin.logistics.util;

import java.math.BigDecimal;

public class PriceCalculator {
  public static long calSupplyPrice(int quantity, int price) {
    return quantity * (long) price;
  }

  public static long calTotalPrice(long supplyPrice, BigDecimal vat) {
    return supplyPrice + VatCalculator.vatToLong(vat);
  }
}
