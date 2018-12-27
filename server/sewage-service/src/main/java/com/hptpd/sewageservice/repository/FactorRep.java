package com.hptpd.sewageservice.repository;//package com.hptpd.sewage.repository;

import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.system.MonitoringSystem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 15:36
 * \* Description: 监测因子Rep
 * \
 */
@Repository("factorRep")
public interface FactorRep extends JpaRepository<Factor, String> {

    Page<Factor> findByMonitoringSystem(MonitoringSystem monitoringSystem, Pageable pageable);

    List<Factor> findByMonitoringSystem(MonitoringSystem monitoringSystem);

    Factor  findByMonitoringSystemAndCode(MonitoringSystem monitoringSystem,String code);
}
