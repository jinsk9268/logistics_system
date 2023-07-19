package com.jin.logistics.repository.shipping;

import com.jin.logistics.domain.shipping.entity.ShippingDetail;
import com.jin.logistics.domain.util.DetailCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDetailRepository extends JpaRepository<ShippingDetail, DetailCompositeKey> {

}
