package com.hptpd.usermanagement.test;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.vo.UserPageVo;
import com.hptpd.usermanagement.domain.vo.UserVo;
import com.hptpd.usermanagement.repository.UserRep;
import com.hptpd.usermanagement.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 彭诗杰
 * \* Date: 2018/12/6
 * \* Time: 22:31
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Resource(name = "userService")
    IUserService userService;

    @Resource(name = "userRep")
    private UserRep userRep;

    @Test
    public void addUserTest() {
        UserVo userVo = new UserVo();
        userVo.setUserName("pengshijie");
        userVo.setName("彭诗杰");
        userVo.setPassword("123456");
        userVo.setGender("男");
        userVo.setCellPhone("18670687350");
        userVo.setDepartment("研发中心");
        logger.info(userService.addUser(userVo).toString());
    }

    @Test
    public void findUserByNameTest() {
        UserPageVo userPageVo = userService.findByName("彭诗杰", PageRequest.of(0, 10));
        Assert.assertSame(userPageVo.getTotal(), 2);
        logger.info(userPageVo.toString());
    }

    @Test
    public void findAllTest() {
        UserPageVo userPageVo = userService.getAllUsers(PageRequest.of(0, 10));
        Assert.assertSame("测试结果有误，用户数据条目不对。", userPageVo.getTotal().intValue(), 2);
        logger.info(userPageVo.toString());
    }

    @Test
    public void removeUserTest() {
        Result result = userService.removeUser("tracy4262");
        logger.info(result.toString());
        Assert.assertSame("测试结果有误", result.getErrCode(), Result.SUCCESS);
    }
}
