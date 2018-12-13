package com.hptpd.usermanagement.service;

import com.hptpd.usermanagement.common.util.AbstractMyBeanUtils;
import com.hptpd.usermanagement.common.util.StringUtil;
import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.repository.AdminRep;
import com.hptpd.usermanagement.repository.RoleRep;
import com.hptpd.usermanagement.repository.UserRep;
import com.hptpd.usermanagement.service.comp.UserInitializer;
import com.hptpd.usermanagement.vo.user.UserPageVo;
import com.hptpd.usermanagement.vo.user.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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

    @Resource(name = "userInitializer")
    private UserInitializer userInitializer;

    @Resource
    private UserRep userRep;

    @Resource
    private AdminRep adminRep;

    @Resource(name = "roleRep")
    private RoleRep roleRep;

    /**
     * 初始化管理员和测试用户
     */
    @Override
    public void init() {
        userInitializer.adminInit();
        userInitializer.testUsersInit();
    }

    /**
     * 新建用户，包括指定用户角色
     * 角色roleVo对象可以为空，则暂时不设定角色
     *
     * @param userVo
     * @return
     */
    @Override
    public Result addUserWithRole(UserVo userVo) {
        User user = UserVo.toDo(userVo);
        // 新建用户
        if (userRep.findById(userVo.getUserName()).isPresent()) {
            return Result.setResult(Result.ERROR, "该用户名已存在！");
        }
        try {
            userRep.save(user);
        } catch (Exception e) {
            return Result.setResult(Result.ERROR, e.toString());
        }
        // 指派角色
        if (null != userVo.getRoleVo() && StringUtil.isNotEmpty(userVo.getRoleVo().getId())) {
            Optional<Role> roleOptional = roleRep.findById(userVo.getRoleVo().getId());
            roleOptional.ifPresent(role -> assigningRole(user, role));
            return Result.setResult(Result.SUCCESS, "新建用户并指派角色成功！");
        }
        return Result.setResult(Result.SUCCESS, "新建用户成功！");
    }

    /**
     * 通过姓名查询用户
     *
     * @param name
     * @param pageable
     * @return
     */
    @Override
    public UserPageVo findByName(String name, Pageable pageable) {
        Page<User> userPage = userRep.findByName(name, pageable);
        return UserPageVo.toPageVo(userPage);
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
        return UserPageVo.toPageVo(userPage);
    }

    /**
     * 删除用户
     *
     * @param name 用户名
     * @return
     */
    @Override
    public Result removeUser(String name) {
        try {
            userRep.deleteById(name);
        } catch (Exception e) {
            Result.setResult(Result.ERROR, "不存在指定用户!");
        }
        return Result.setResult(Result.SUCCESS, "删除用户成功!");
    }

    /**
     * 更新用户信息，包括给用户指派新的角色
     *
     * @param userVo
     * @return
     */
    @Override
    public Result updateUser(UserVo userVo) {
        User user = updateUserInfo(userVo);

        if (null != userVo.getRoleVo() && StringUtil.isNotEmpty(userVo.getRoleVo().getId())) {
            Optional<Role> roleOptional = roleRep.findById(userVo.getRoleVo().getId());
            roleOptional.ifPresent(role -> assigningRole(user, role));
            return Result.setResult(Result.SUCCESS, "更新用户信息并指派新角色成功！");
        }
        return Result.setResult(Result.SUCCESS, "更新用户信息成功！");
    }

    private User updateUserInfo(UserVo userVo) {
        Optional<User> userOptional = userRep.findById(userVo.getUserName());
        if (userOptional.isPresent()) {
            AbstractMyBeanUtils.copyProperties(userVo, userOptional.get(), "userName");
            userRep.save(userOptional.get());
            return userOptional.get();
        }
        return null;
    }

    /**
     * 给用户指派新的角色：1.删除旧角色关联；2.设置新的角色
     *
     * @param user
     * @param role
     * @return
     */
    private Boolean assigningRole(User user, Role role) {
        Boolean flag = false;
        if (null != user && null != role) {
            user.setRole(role);
            role.getUsers().add(user);
            userRep.save(user);
            flag = true;
        }
        return flag;
    }
}
