package com.jin.logistics.util;

import java.math.BigDecimal;

public class PriceCalculator {

  public static int calBoxSupplyPrice(int boxQuantity, int supplyPrice) {
    return boxQuantity * supplyPrice;
  }
  public static long calSupplyPrice(int quantity, int price) {
    return quantity * (long) price;
  }

  public static long calTotalPrice(long supplyPrice, BigDecimal vat) {
    return supplyPrice + VatCalculator.vatToLong(vat);
  }
}
