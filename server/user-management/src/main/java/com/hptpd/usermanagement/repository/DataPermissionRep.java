package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.DataPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:21
 * \* Description: 用户Rep
 * \
 */
@Repository("dataPermissionRep")
public interface DataPermissionRep extends JpaRepository<DataPermission, String> {

}
