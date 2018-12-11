package com.hptpd.usermanagement.vo.role;

import com.google.common.collect.Sets;
import com.hptpd.usermanagement.common.util.AbstractMyBeanUtils;
import com.hptpd.usermanagement.component.PageBase;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.RoleMenu;
import org.springframework.data.domain.Page;

import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/9
 * \* @time: 20:16
 * \* Description:
 * \
 */
public class RolePageVo extends PageBase {

    private Set<RoleVo> roles;

    public Set<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleVo> roles) {
        this.roles = roles;
    }

    public static RolePageVo toPageVo(Page<Role> rolePage) {
        RolePageVo rolePageVo = new RolePageVo();
        Set<RoleVo> roleVos = Sets.newLinkedHashSet();
        for (Role role : rolePage) {
            RoleVo roleVo = new RoleVo();
            AbstractMyBeanUtils.copyProperties(role, roleVo);
            roleVos.add(roleVo);
        }
        rolePageVo.setRoles(roleVos);
        rolePageVo.setLimit(rolePage.getNumberOfElements());
        rolePageVo.setTotal(rolePage.getTotalElements());
        return rolePageVo;
    }

    @Override
    public String toString() {
        return "RolePageVo{" +
                "roles=" + roles +
                ", total=" + total +
                ", limit=" + limit +
                '}';
    }
}
