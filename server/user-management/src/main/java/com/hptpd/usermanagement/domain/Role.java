package com.hptpd.usermanagement.domain;

import com.hptpd.usermanagement.domain.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 11:14
 * \* Description: 角色类
 * \
 */
@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "role")
    private List<RoleMenu> roleMenus;
}
