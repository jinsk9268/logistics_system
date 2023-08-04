package com.jin.logistics.util;

import com.jin.logistics.domain.order.entity.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

public class PriceCalculator {

  public static int calBoxSupplyPrice(int boxQuantity, int supplyPrice) {
    return boxQuantity * supplyPrice;
  }

  public static long calProductSupplyPrice(int quantity, int supplyPrice) {
    return quantity * (long) supplyPrice;
  }

  public static int calTotalQuantityFromEntity(List<OrderDetail> orderDetails) {
    return orderDetails.stream().mapToInt(OrderDetail::getQuantity).sum();
  }

  public static long calTotalSupplyPriceFromEntity(List<OrderDetail> orderDetails) {
    return orderDetails.stream().mapToLong(OrderDetail::getProductSupplyPrice).sum();
  }

  public static BigDecimal calTotalVatFromEntity(List<OrderDetail> orderDetails) {
    return orderDetails.stream().map(OrderDetail::getProductVat).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public static long calTotalAmount(long productSupplyPrice, BigDecimal productVat) {
    return productSupplyPrice + VatCalculator.vatToLong(productVat);
  }
}
