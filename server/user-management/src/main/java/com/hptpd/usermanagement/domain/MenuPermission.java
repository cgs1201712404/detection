package com.hptpd.usermanagement.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 14:33
 * \* Description: 菜单级权限
 * \
 */
@Entity
@Table(name = "menu_permission")
@Data
public class MenuPermission {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * 菜单名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 菜单路径
     */
    @Column(name = "path")
    private String path;

    @OneToMany(mappedBy = "menuPermission")
    private List<RoleMenu> roleMenus;
}
