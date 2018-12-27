
package com.hptpd.sewageservice.repository;

import com.hptpd.sewageservice.domain.Factor;
import com.hptpd.sewageservice.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("historyRep")
public interface HistoryRep extends JpaRepository<History,String> {
    List<History> findByFactor(Factor factor);

    Page<History> findByFactor(Factor factor, Pageable pageable);
}
