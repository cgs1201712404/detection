package com.hptpd.usermanagement.domain.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:14
 * \* Description: 管理员类
 * \
 */
@Entity
@Table(name = "admin")
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends AbstractUser {

    public Admin() {

    }

    public Admin(String userName, String password) {
        super(userName, password);
    }
}
