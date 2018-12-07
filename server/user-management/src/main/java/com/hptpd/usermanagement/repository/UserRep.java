package com.hptpd.usermanagement.repository;

import com.hptpd.usermanagement.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@Repository("userRep")
public interface UserRep extends JpaRepository<User, String> {

    Page<User> findByName(String name, Pageable pageable);
}
