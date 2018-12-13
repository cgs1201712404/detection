package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 14:54
 * \* Description:
 * \
 */
public interface RoleRep extends JpaRepository<Role, String> {

}
