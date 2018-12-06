package com.hptpd.usermanagement.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* Date: 2018/12/6
 * \* Time: 8:53
 * \* Description:
 * \
 */

@Data
@MappedSuperclass
public class User {

    @Id
    private String userName;

    @Column(name = "password")
    private String password;

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


}
