package com.hptpd.usermanagement.service;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.vo.role.MenuVo;
import com.hptpd.usermanagement.vo.role.RolePageVo;
import com.hptpd.usermanagement.vo.role.RoleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/7
 * \* @time: 17:16
 * \* Description: 角色service接口
 * \
 */
public interface IRoleService {

    /**
     * 基本角色初始化工作
     * @return
     */
    List<Role> roleInit();

    /**
     * 新建角色，单纯在数据库中写入角色表
     *
     * @param roleVo
     * @return
     */
    Role addRole(RoleVo roleVo);

    /**
     * 更新角色，更新name和 note属性
     *
     * @param roleVo
     * @return
     */
    Result updateRole(RoleVo roleVo);

    /**
     * 删除角色，根据角色名删除
     *
     * @param id
     * @return
     */
    Result removeRole(String id);

    /**
     * 新建角色，并分配前端指定的默认权限
     *
     * @param roleVo
     * @return
     */
    Result addRoleDefault(RoleVo roleVo);

    /**
     * 分页获取所有的角色
     *
     * @param pageable
     * @return
     */
    RolePageVo getAllRoles(Pageable pageable);

    /**
     * 为角色分配权限
     *
     * @param roleVo
     * @param menuVos
     * @return
     */
    Result grantPermissions(RoleVo roleVo, List<MenuVo> menuVos);

    /**
     * 通过角色id获取角色相关信息，包括权限信息
     *
     * @param id
     * @return
     */
    Result findRoleById(String id);
}
