package com.hptpd.usermanagement.vo.role;

import com.hptpd.usermanagement.common.util.StringUtil;
import com.hptpd.usermanagement.domain.Role;
import lombok.Data;
import org.springframework.lang.NonNull;

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
}
