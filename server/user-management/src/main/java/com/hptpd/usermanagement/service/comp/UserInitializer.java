package com.hptpd.usermanagement.service.comp;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.domain.user.Admin;
import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.repository.AdminRep;
import com.hptpd.usermanagement.repository.UserRep;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/10
 * \* @time: 0:29
 * \* Description:用户初始化类（负责测试和基本用户的整体初始化工作）
 * \
 */
@Component("userInitializer")
public class UserInitializer {

    @Resource(name = "userRep")
    private UserRep userRep;

    @Resource(name = "adminRep")
    private AdminRep adminRep;

    public void adminInit() {
        Optional<Admin> adminOptional = adminRep.findById("admin");
        adminOptional.orElseGet(() -> adminRep.save(new Admin("admin", "admin")));
    }

    public void testUsersInit() {
        List<User> users = Lists.newArrayList();
        users.add(simulatePengshijie());
        users.add(simulateLiucheng());
        userRep.saveAll(users);
    }

    private User simulatePengshijie() {
        User user = new User();
        user.setUserName("pengshijie");
        user.setName("彭诗杰");
        user.setPassword("123456");
        user.setGender("男");
        user.setCellPhone("18670687350");
        user.setDepartment("研发中心");
        return user;
    }

    private User simulateLiucheng() {
        User user = new User();
        user.setUserName("liucheng");
        user.setName("刘成");
        user.setPassword("123456");
        user.setGender("男");
        user.setCellPhone("17671792752");
        user.setDepartment("研发中心");
        return user;
    }
}
