package com.hptpd.sewageservice.repository;//package com.hptpd.sewage.repository;

import com.hptpd.sewageservice.domain.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
