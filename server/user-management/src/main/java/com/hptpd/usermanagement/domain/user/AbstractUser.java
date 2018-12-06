package com.hptpd.usermanagement.domain.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* Date: 2018/12/6
 * \* Time: 8:53
 * \* Description: 用户基类
 * \
 */

@Data
@MappedSuperclass
abstract class AbstractUser {

    AbstractUser() {

    }

    AbstractUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Id
    private String userName;

    @Column(name = "password")
    private String password;

}
