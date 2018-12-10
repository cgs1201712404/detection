package com.hptpd.usermanagement.service.comp;

import com.hptpd.usermanagement.domain.Role;
import com.hptpd.usermanagement.repository.RoleRep;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/10
 * \* @time: 10:44
 * \* Description: 用户初始化类（负责测试和基本角色的整体初始化工作）
 * \
 */
@Component("roleInitializer")
public class RoleInitializer {

    @Resource(name = "roleRep")
    private RoleRep roleRep;

    public void roleInit() {

    }

}
