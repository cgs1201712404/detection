package com.hptpd.usermanagement.service;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.user.Admin;
import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.domain.vo.UserPageVo;
import com.hptpd.usermanagement.domain.vo.UserVo;
import com.hptpd.usermanagement.repository.AdminRep;
import com.hptpd.usermanagement.repository.UserRep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 新建用户
     *
     * @param userVo
     * @return
     */
    @Override
    public Result addUser(UserVo userVo) {
        User user = UserVo.toDo(userVo);

        if (userRep.findById(userVo.getUserName()).isPresent()) {
            return Result.setResult(Result.ERROR, "该用户名已存在！");
        }
        try {
            userRep.save(user);
        } catch (Exception e) {
            return Result.setResult(Result.ERROR, e.toString());
        }
        return Result.setResult(Result.SUCCESS, "新建用户成功！");
    }

    /**
     * 通过姓名查询用户
     *
     * @param name
     * @return
     */
    @Override
    public UserPageVo findByName(String name, Pageable pageable) {
        Page<User> userPage = userRep.findByName(name, pageable);
        UserPageVo userPageVo = UserPageVo.toPageVo(userPage);
        return userPageVo;
    }

    /**
     * 获取所有用户
     *
     * @param pageable
     * @return
     */
    @Override
    public UserPageVo getAllUsers(Pageable pageable) {
        Page<User> userPage = userRep.findAll(pageable);
        UserPageVo userPageVo = UserPageVo.toPageVo(userPage);
        return userPageVo;
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
