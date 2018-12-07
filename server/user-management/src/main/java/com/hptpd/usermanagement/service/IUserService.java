package com.hptpd.usermanagement.service;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.domain.vo.UserPageVo;
import com.hptpd.usermanagement.domain.vo.UserVo;
import org.springframework.data.domain.Pageable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 10:24
 * \* Description:
 * \
 */
public interface IUserService {

    /**
     * 初始化管理员和测试用户
     */
    void init();

    /**
     * 新建用户
     *
     * @param userVo
     * @return
     */
    Result addUser(UserVo userVo);

    /**
     * 通过姓名查询用户
     *
     * @param name
     * @param pageable
     * @return
     */
    UserPageVo findByName(String name, Pageable pageable);

    /**
     * 获取所有用户
     *
     * @param pageable
     * @return
     */
    UserPageVo getAllUsers(Pageable pageable);

    /**
     * 删除用户
     *
     * @param name
     * @return
     */
    Result removeUser(String name);
}
