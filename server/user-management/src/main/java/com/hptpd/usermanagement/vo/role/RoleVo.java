package com.hptpd.usermanagement.vo.role;

import com.hptpd.usermanagement.common.util.StringUtil;
import com.hptpd.usermanagement.domain.DataPermission;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.RoleMenu;
import com.hptpd.usermanagement.service.comp.PermissionInitializer;
import lombok.Data;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 2:27
 * \* Description:
 * \
 */
@Data
public class RoleVo {

    private String id;

    private String name;

    private String note;

    private List<MenuVo> permissionGroup;

    public RoleVo(String id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public RoleVo(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public RoleVo() {

    }

    public static Role toDo(RoleVo roleVo) {
        Role role = new Role();
        if (!StringUtil.isEmpty(roleVo.getId())) {
            role.setId(roleVo.getId());
        }
        role.setNote(roleVo.getNote());
        role.setName(roleVo.getName());
        return role;
    }

    public static RoleVo toVo(Role role) {
        return new RoleVo(role.getId(), role.getName(), role.getNote());
    }


    @Resource(name = "permissionInitializer")
    private static PermissionInitializer permissionInitializer;

    /**
     * 将Role转为RoleVo，包括Role对象的权限数据深层次遍历
     *
     * @param role
     * @return
     */
    public static RoleVo toVoDeep(Role role) {
        RoleVo roleVo = toVo(role);

        List<MenuVo> baseMenus = permissionInitializer.generateBaseMenu();
        for (MenuVo baseMenu : baseMenus) {
            // 设置菜单权限
            for (RoleMenu roleMenu : role.getRoleMenus()) {
                MenuVo menuVo = MenuVo.toVo(roleMenu.getMenuPermission());
                if (menuVo.equals(baseMenu)) {
                    baseMenu.setChecked(true);
                    break;
                }
                // 设置数据权限
                for (DataVo baseData : baseMenu.getPermission()) {
                    for (DataPermission dataPermission : roleMenu.getDataPermissions()) {
                        DataVo dataVo = DataVo.toVo(dataPermission);
                        if (dataVo.equals(baseData)) {
                            baseData.setChecked(true);
                            break;
                        }
                    }
                }
            }
        }
        roleVo.setPermissionGroup(baseMenus);
        return roleVo;
    }
}
