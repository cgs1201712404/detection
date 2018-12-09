package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.MenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:31
 * \* Description: 用户模块逻辑
 * \
 */
@Repository("menuPermissionRep")
public interface MenuPermissionRep extends JpaRepository<MenuPermission, String> {
}
