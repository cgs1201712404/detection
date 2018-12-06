package com.hptpd.usermanagement.domain.user;

import com.hptpd.usermanagement.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* Date: 2018/12/6
 * \* Time: 10:02
 * \* Description: 用户对象
 * \
 */
@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractUser {
    public User(String userName, String password) {
        super(userName, password);
    }

    public User() {

    }

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 手机
     */
    @Column(name = "cell_phone")
    private String cellPhone;

    /**
     * 部门
     */
    @Column(name = "department")
    private String department;

    /**
     * 职务
     */
    @Column(name = "position")
    private String position;

    @OneToOne(mappedBy = "user")
    private Role role;
}
