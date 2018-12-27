package com.hptpd.sewageservice.repository;

import com.hptpd.sewageservice.domain.SewageArea;
import com.hptpd.sewageservice.domain.system.MonitoringSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("monitoringRep")
public interface MonitoringRep extends JpaRepository<MonitoringSystem,String> {
    List<MonitoringSystem> findBySewageArea(SewageArea sewageArea);
}
