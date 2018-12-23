package com.hptpd.centralpivot.station.repository;

import com.hptpd.centralpivot.station.domain.ServiceArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:25
 * \* Description: 服务区类rep
 * \
 */
@Repository("serviceAreaRep")
public interface ServiceAreaRep extends JpaRepository<ServiceArea, String> {

}
