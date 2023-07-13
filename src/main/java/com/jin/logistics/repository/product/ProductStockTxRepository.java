package com.jin.logistics.repository.product;

import com.jin.logistics.domain.product.ProductStockTx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockTxRepository extends JpaRepository<ProductStockTx, Long> {

}
