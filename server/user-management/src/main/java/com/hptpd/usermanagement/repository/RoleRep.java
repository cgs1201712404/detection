package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 彭诗杰
 * \* Date: 2018/12/7
 * \* Time: 22:26
 * \* Description: 角色Rep
 * \
 */
public interface RoleRep extends JpaRepository<Role, String> {

}
