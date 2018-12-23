package com.hptpd.centralpivot.station.repository;

import com.hptpd.centralpivot.station.domain.ServiceAreaRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/23
 * \* @time: 17:26
 * \* Description: 服务区关系类rep
 * \
 */
@Repository("serviceAreaRelationRep")
public interface ServiceAreaRelationRep extends JpaRepository<ServiceAreaRelation, String> {

}
