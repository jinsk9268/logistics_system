package com.jin.logistics.repository.order;

import com.jin.logistics.domain.order.OrderDetail;
import com.jin.logistics.domain.order.OrderDetailPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPk> {

}
