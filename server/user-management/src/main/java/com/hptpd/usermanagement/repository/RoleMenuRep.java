package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 14:54
 * \* Description:
 * \
 */
@Repository("roleMenuRep")
public interface RoleMenuRep extends JpaRepository<RoleMenu, String> {

    List<RoleMenu> findByRole(Role role);
}
