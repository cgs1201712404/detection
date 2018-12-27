package com.hptpd.sewageservice.repository;

import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.RealTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: lc
 * \* @date: 2018/12/27
 * \* @time: 10:24
 * \* Description:
 * \
 */
@Repository("realTimeRep")
public interface RealTimeRep extends JpaRepository<RealTime,String> {
    Page<RealTime> findByFactor(Factor factor, Pageable pageable);
}
