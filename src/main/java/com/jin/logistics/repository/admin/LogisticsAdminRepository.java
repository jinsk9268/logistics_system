package com.jin.logistics.repository.admin;

import com.jin.logistics.domain.admin.entity.LogisticsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsAdminRepository extends JpaRepository<LogisticsAdmin, String> {

}
