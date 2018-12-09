package com.hptpd.usermanagement.generation;

import com.hptpd.usermanagement.service.IPermissionService;
import com.hptpd.usermanagement.service.IUserService;
import com.hptpd.usermanagement.vo.user.UserPageVo;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 1:46
 * \* Description: 系统中默认数据的初始化工作。比如管理员数据、权限数据等
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInit {

    @Resource(name = "rolePermissionService")
    private IPermissionService permissionService;

    @Resource(name = "userService")
    private IUserService userService;

    @Test
    public void dataAndMenuPermissionInit() {
        boolean result = permissionService.initPermissions();
        assertTrue(result);
    }

    @Test
    public void adminAndTestUsersInit() {
        userService.init();
        UserPageVo userPageVo = userService.getAllUsers(PageRequest.of(0, 10));
        assertEquals(userPageVo.getTotal().intValue(), 2);
    }
}
