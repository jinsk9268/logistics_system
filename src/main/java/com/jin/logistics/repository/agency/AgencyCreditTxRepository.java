package com.jin.logistics.repository.agency;

import com.jin.logistics.domain.agency.AgencyCreditTx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyCreditTxRepository extends JpaRepository<AgencyCreditTx, Long> {

}
