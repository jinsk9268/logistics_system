package com.jin.logistics.repository.order;

import com.jin.logistics.domain.order.entity.OrderDetail;
import com.jin.logistics.domain.util.DetailCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, DetailCompositeKey> {

  List<OrderDetail> findAllByOrderId(Long orderId);
}
