package com.hptpd.usermanagement.test;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.repository.RoleRep;
import com.hptpd.usermanagement.service.IRoleService;
import com.hptpd.usermanagement.service.comp.PermissionInitializer;
import com.hptpd.usermanagement.vo.role.MenuVo;
import com.hptpd.usermanagement.vo.role.RoleVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 彭诗杰
 * \* Date: 2018/12/7
 * \* Time: 22:29
 * \* Description: 角色模块测试
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    private Logger logger = LoggerFactory.getLogger(RoleTest.class);

    @Resource(name = "rolePermissionService")
    private IRoleService roleService;

    @Resource(name = "roleRep")
    private RoleRep roleRep;

    @Resource(name = "permissionInitializer")
    private PermissionInitializer initializer;

    @Test
    @Transactional
    public void addRoleTest() {
        RoleVo roleVo = new RoleVo();
        roleVo.setName("运维人员");
        roleVo.setNote("这是运维人员角色");
        Role role = roleService.addRole(roleVo);
        logger.info(role.toString());
        Assert.assertNotNull("测试未通过", role);
    }

    @Test
    @Transactional
    public void updateRoleTest() {

        roleService.updateRole(new RoleVo("402880e567921e230167921e3a3b0000",
                "修改后的部门经理", "这是修改后的部门经理"));
        Optional<Role> roleOptional = roleRep.findById("402880e567921e230167921e3a3b0000");
        roleOptional.ifPresent(role -> Assert.assertEquals("修改后的部门经理", role.getName()));
    }

    @Test
    @Transactional
    public void removeRoleTest() {
        roleService.removeRole("402880e567921e230167921e3a3b0000");
        Optional<Role> roleOptional = roleRep.findById("402880e567921e230167921e3a3b0000");
        Assert.assertFalse(roleOptional.isPresent());
    }

    @Test
    public void grantPermissionsTest() {
        RoleVo roleVo = new RoleVo();
        roleVo.setName("管理员");
        roleVo.setNote("这是管理员的角色权限");
        List<MenuVo> menuVos = initializer.simulateTestMenuData();
        Result result = roleService.grantPermissions(roleVo, menuVos);
        logger.info(result.toString());
        Assert.assertEquals(Result.SUCCESS, result.getErrCode());
    }
}
