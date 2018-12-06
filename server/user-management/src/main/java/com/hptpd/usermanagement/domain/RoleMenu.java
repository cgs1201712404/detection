package com.hptpd.usermanagement.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 11:29
 * \* Description: 角色菜单中间实体
 * \
 */
@Entity
@Table(name = "role_menu")
@Data
public class RoleMenu {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private MenuPermission menuPermission;

    @ManyToMany
    private List<DataPermission> dataPermissions;
}
