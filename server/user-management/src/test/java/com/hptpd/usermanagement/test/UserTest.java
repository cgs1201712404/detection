package com.hptpd.usermanagement.test;

import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.repository.UserRep;
import com.hptpd.usermanagement.service.IUserService;
import com.hptpd.usermanagement.vo.user.UserPageVo;
import com.hptpd.usermanagement.vo.user.UserVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 彭诗杰
 * \* Date: 2018/12/6
 * \* Time: 22:31
 * \* Description: 用户模块测试
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Resource(name = "userService")
    private IUserService userService;

    @Resource(name = "userRep")
    private UserRep userRep;

    @Test
    @Transactional
    public void addUserTest() {
        UserVo userVo = new UserVo();
        userVo.setUserName("ceshi1");
        userVo.setName("彭诗杰");
        userVo.setPassword("123456");
        userVo.setGender("男");
        userVo.setCellPhone("18670687350");
        userVo.setDepartment("研发中心");
        logger.info(userService.addUserWithRole(userVo).toString());
        Optional<User> userOptional = userRep.findById(userVo.getUserName());
        userOptional.ifPresent(Assert::assertNotNull);
    }

    @Test
    public void findUserByNameTest() {
        UserPageVo userPageVo = userService.findByName("彭诗杰", PageRequest.of(0, 10));
        Assert.assertSame(userPageVo.getTotal().intValue(), 1);
        logger.info(userPageVo.toString());
    }

    @Test
    public void findAllTest() {
        UserPageVo userPageVo = userService.getAllUsers(PageRequest.of(0, 10));
        Assert.assertSame("测试结果有误，用户数据条目不对。", userPageVo.getTotal().intValue(), 2);
        logger.info(userPageVo.toString());
    }

    @Test
    @Transactional
    public void removeUserTest() {
        userService.removeUser("pengshijie");
        Optional<User> userOptional = userRep.findById("pengshijie");
        Assert.assertFalse("测试结果有误", userOptional.isPresent());
    }



}
