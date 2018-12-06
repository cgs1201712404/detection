package com.hptpd.usermanagement.generation;

import com.hptpd.usermanagement.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:59
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateTestData {

    @Resource(name = "userService")
    public IUserService userService;

    @Test
    public void generateAdminAndFirstUser() {
        userService.init();
    }
}
