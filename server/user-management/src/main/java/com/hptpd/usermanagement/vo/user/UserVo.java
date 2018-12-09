package com.hptpd.usermanagement.vo.user;

import com.hptpd.usermanagement.common.util.AbstractMyBeanUtils;
import com.hptpd.usermanagement.domain.user.User;
import com.hptpd.usermanagement.vo.role.RoleVo;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 11:09
 * \* Description: 用户类Vo
 * \
 */
@Data
public class UserVo {

    private String userName;

    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机
     */
    private String cellPhone;

    /**
     * 部门
     */
    private String department;

    /**
     * 职务
     */
    private String position;

    /**
     * 角色
     */
    private RoleVo roleVo;

    public static User toDo(UserVo userVo) {
        User user = new User();
        AbstractMyBeanUtils.copyProperties(userVo, user);
        return user;
    }

    public static UserVo toVo(User user) {
        UserVo userVo = new UserVo();
        AbstractMyBeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}
