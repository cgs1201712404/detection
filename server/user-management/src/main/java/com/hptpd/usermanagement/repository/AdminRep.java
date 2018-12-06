package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:22
 * \* Description: 管理员Rep
 * \
 */
@Repository("adminRep")
public interface AdminRep extends JpaRepository<Admin, String> {
}
