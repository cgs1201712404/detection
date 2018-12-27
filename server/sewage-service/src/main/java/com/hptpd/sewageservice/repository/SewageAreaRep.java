package com.hptpd.sewageservice.repository;//package com.hptpd.sewage.repository;

import com.hptpd.sewageservice.domain.SewageArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/17
 * \* @time: 11:34
 * \* Description: 污水服务区Rep
 * \
 */
@Repository("sewageAreaRep")
public interface SewageAreaRep extends JpaRepository<SewageArea, String>{

}
