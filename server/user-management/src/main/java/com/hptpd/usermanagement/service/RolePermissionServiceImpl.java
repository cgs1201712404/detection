package com.hptpd.usermanagement.service;

import com.hptpd.usermanagement.common.util.StringUtil;
import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.DataPermission;
import com.hptpd.usermanagement.domain.MenuPermission;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.RoleMenu;
import com.hptpd.usermanagement.repository.DataPermissionRep;
import com.hptpd.usermanagement.repository.MenuPermissionRep;
import com.hptpd.usermanagement.repository.RoleMenuRep;
import com.hptpd.usermanagement.repository.RoleRep;
import com.hptpd.usermanagement.service.comp.PermissionInitializer;
import com.hptpd.usermanagement.vo.role.DataVo;
import com.hptpd.usermanagement.vo.role.MenuVo;
import com.hptpd.usermanagement.vo.role.RolePageVo;
import com.hptpd.usermanagement.vo.role.RoleVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* Date: 2018/12/7
 * \* Time: 22:31
 * \* Description:
 * \
 */
@Service("rolePermissionService")
@Transactional(rollbackFor = Exception.class)
public class RolePermissionServiceImpl implements IRoleService, IPermissionService {

    @Resource(name = "permissionInitializer")
    private PermissionInitializer initializer;

    @Resource(name = "roleRep")
    private RoleRep roleRep;

    @Resource(name = "roleMenuRep")
    private RoleMenuRep roleMenuRep;

    @Resource(name = "menuPermissionRep")
    private MenuPermissionRep menuPermissionRep;

    @Resource(name = "dataPermissionRep")
    private DataPermissionRep dataPermissionRep;

    /**
     * 初始化权限项
     */
    @Override
    public boolean initPermissions() {
        boolean flag = false;
        List<MenuPermission> menuPermissions = initializer.menuPermissionInit();
        List<DataPermission> dataPermissions = initializer.dataPermissionInit();
        if (!menuPermissions.isEmpty() && !dataPermissions.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 新建角色，单纯在数据库中写入角色表
     *
     * @param roleVo
     * @return
     */
    @Override
    public Role addRole(RoleVo roleVo) {
        Role role = new Role();
        role.setName(roleVo.getName());
        role.setNote(roleVo.getNote());
        roleRep.save(role);
        return role;
    }

    /**
     * 更新角色，更新name和 note属性
     *
     * @param roleVo
     * @return
     */
    @Override
    public Result updateRole(RoleVo roleVo) {
        Optional<Role> roleOptional = roleRep.findById(roleVo.getId());
        if (roleOptional.isPresent()) {
            roleOptional.get().setName(roleVo.getName());
            roleOptional.get().setNote(roleVo.getNote());
            roleRep.save(roleOptional.get());
            return Result.setResult(Result.SUCCESS, "更新角色信息！");
        }
        return Result.setResult(Result.ERROR, "不存在此角色！");
    }

    /**
     * 删除角色，根据角色名删除
     *
     * @param id
     * @return
     */
    @Override
    public Result removeRole(String id) {
        if (StringUtil.isEmpty(id)) {
            return Result.setResult(Result.ERROR, "角色id为空值!");
        }

        Optional<Role> roleOptional = roleRep.findById(id);
        if (!roleOptional.isPresent()) {
            return Result.setResult(Result.ERROR, "此角色不存在!");
        }

        roleRep.deleteById(id);
        return Result.setResult(Result.SUCCESS, "角色删除成功!");
    }

    /**
     * 分页获取所有的角色
     *
     * @param pageable
     * @return
     */
    @Override
    public RolePageVo getAllRoles(Pageable pageable) {
        Page<Role> rolePage = roleRep.findAll(pageable);
        return RolePageVo.toPageVo(rolePage);
    }

    /**
     * 新建角色，并分配前端指定的默认权限
     *
     * @param roleVo
     * @return
     */
    @Override
    public Result addRoleDefault(RoleVo roleVo) {
        Role role = this.addRole(roleVo);
        return this.grantPermissions(RoleVo.toVo(role), roleVo.getPermissionGroup());
    }

    /**
     * 为角色分配权限
     *
     * @param roleVo  角色vo对象，此处roleVo中只需要设置name 和 note属性
     * @param menuVos
     * @return
     */
    @Override
    public Result grantPermissions(RoleVo roleVo, List<MenuVo> menuVos) {
        if (StringUtil.isEmpty(roleVo.getName())) {
            return Result.setResult(Result.ERROR, "角色名为空值！");
        }
        Optional<Role> roleOptional = roleRep.findById(roleVo.getId());
        if (roleOptional.isPresent()) {
            /*
              一：删除该角色中已有的RoleMenu对象
              二：根据roleVo中 MenuVo 和 DataVo重建 RoleMenu
             */
            List<RoleMenu> roleMenus = roleMenuRep.findByRole(roleOptional.get());

            for (RoleMenu roleMenu : roleMenus) {
                roleMenu.removeSelf(roleMenuRep);
            }

            for (MenuVo menuVo : menuVos) {
                if (menuVo.getChecked()) {
                    // 如果menu的 checked属性为真
                    // 设置 role roleMenu menu三方关系
                    MenuPermission menuPermission = menuPermissionRep.findById(menuVo.getName()).get();
                    RoleMenu roleMenu = new RoleMenu(roleOptional.get(), menuPermission);
                    roleMenu.setMenuPermission(menuPermission);

                    for (DataVo dataVo : menuVo.getPermission()) {
                        DataPermission dataPermission = dataPermissionRep.findById(dataVo.getValue()).get();
                        roleMenu.addDataPermission(dataPermission);
                    }
                    roleMenuRep.save(roleMenu);
                }
            }
            return Result.setResult(Result.SUCCESS, "权限分配成功！");
        } else {
            return Result.setResult(Result.ERROR, "该角色不存在！");
        }
    }
}
