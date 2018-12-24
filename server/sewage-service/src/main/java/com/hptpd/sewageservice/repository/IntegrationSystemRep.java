package com.hptpd.sewageservice.repository;

import com.hptpd.sewageservice.domain.system.BaseIntegrationSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 15:53
 * \* Description:
 * \
 */
@Repository("integrationSystemRep")
public interface IntegrationSystemRep extends JpaRepository<BaseIntegrationSystem, String> {
}
