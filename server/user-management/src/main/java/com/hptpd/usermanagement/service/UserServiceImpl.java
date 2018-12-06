package com.hptpd.usermanagement.service;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.domain.user.Admin;
import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.repository.AdminRep;
import com.hptpd.usermanagement.repository.UserRep;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:31
 * \* Description: 用户模块逻辑
 * \
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserRep userRep;

    @Resource
    private AdminRep adminRep;

    /**
     * 初始化管理员和测试用户
     */
    @Override
    public void init() {
        Admin admin = initAdmin();
        List<User> users = initUsers();
    }

    private Admin initAdmin() {
        Optional<Admin> adminOptional = adminRep.findById("admin");
        return adminOptional.orElseGet(() -> adminRep.save(new Admin("admin", "admin")));
    }

    private List<User> initUsers() {
        User user = new User("tracy4262", "123456");
        List<User> users = Lists.newArrayList();
        users.add(user);
        userRep.saveAll(users);
        return users;
    }

}
