package com.hptpd.usermanagement.vo.user;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.common.util.AbstractMyBeanUtils;
import com.hptpd.usermanagement.component.PageBase;
import com.hptpd.usermanagement.domain.user.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 2:27
 * \* Description:
 * \
 */
public class UserPageVo extends PageBase {

    private List<UserVo> users;

    public List<UserVo> getUsers() {
        return users;
    }

    public void setUsers(List<UserVo> users) {
        this.users = users;
    }

    public static UserPageVo toPageVo(Page<User> userPage) {
        UserPageVo userPageVo = new UserPageVo();
        List<UserVo> userVos = Lists.newLinkedList();
        for (User user : userPage) {
            UserVo userVo = new UserVo();
            AbstractMyBeanUtils.copyProperties(user, userVo);
            userVos.add(userVo);
        }
        userPageVo.setUsers(userVos);
        userPageVo.setLimit(userPage.getNumberOfElements());
        userPageVo.setTotal(userPage.getTotalElements());
        return userPageVo;
    }

    @Override
    public String toString() {
        return "UserPageVo{" +
                "users=" + users +
                ", total=" + total +
                ", limit=" + limit +
                '}';
    }
}
