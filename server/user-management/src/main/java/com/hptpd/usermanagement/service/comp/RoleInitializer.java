package com.hptpd.usermanagement.service.comp;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.repository.RoleRep;
import com.hptpd.usermanagement.service.IRoleService;
import com.hptpd.usermanagement.vo.role.MenuVo;
import com.hptpd.usermanagement.vo.role.RoleVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/10
 * \* @time: 10:44
 * \* Description: 用户初始化类（负责测试和基本角色的整体初始化工作）
 * \
 */
@Component("roleInitializer")
public class RoleInitializer {

    @Resource(name = "permissionInitializer")
    private PermissionInitializer permissionInitializer;

    @Resource(name = "rolePermissionService")
    private IRoleService roleService;

    public List<Role> roleInit() {
        List<Role> roles = Lists.newLinkedList();
        roles.add(managerRoleInit());
        return roles;
    }

    private Role managerRoleInit() {
        RoleVo roleVo = new RoleVo("经理", "这是经理权限的角色");
        List<MenuVo> menuVos = permissionInitializer.simulateTestMenuData();
        Role role = roleService.addRole(roleVo);
        roleService.grantPermissions(roleVo, menuVos);
        return role;
    }

}
