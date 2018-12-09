package com.hptpd.usermanagement.domain;

import com.google.common.collect.Sets;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    /**
     * 菜单名称
     */
    @Id
    @Column(name = "name")
    private String name;

    /**
     * 菜单路径
     */
    @Column(name = "path")
    private String path;

    /**
     * 菜单label
     */
    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "menuPermission", fetch = FetchType.EAGER)
    private Set<RoleMenu> roleMenus = Sets.newLinkedHashSet();

    @Override
    public String toString() {
        return "MenuPermission{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
