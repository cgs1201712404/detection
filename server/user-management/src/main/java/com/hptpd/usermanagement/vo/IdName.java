package com.hptpd.usermanagement.vo;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/13
 * \* @time: 15:53
 * \* Description: 单纯携带ID和名称的vo对象（用于返回全量数据的情况）
 * \
 */
@Data
@AllArgsConstructor
public class IdName {

    private String id;

    private String name;

    public static List<IdName> fromRoles(List<Role> roles) {
        List<IdName> idNames = Lists.newLinkedList();
        for (Role role: roles) {
            idNames.add(new IdName(role.getId(), role.getName()));
        }
        return idNames;
    }
}
