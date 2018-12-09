package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.DataPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 彭诗杰
 * \* Date: 2018/12/7
 * \* Time: 23:49
 * \* Description: 数据控制权限Rep
 * \
 */
@Repository("dataPermissionRep")
public interface DataPermissionRep extends JpaRepository<DataPermission, String> {

}
