package com.hptpd.usermanagement.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 14:50
 * \* Description:
 * \
 */
@Entity
@Table(name = "data_permission")
@Data
public class DataPermission {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * 数据操作名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 数据操作对应url
     */
    @Column(name = "url")
    private String url;

    /**
     * 数据操作请求类型（GET, POST, DELETE）
     */
    @Column(name = "request_type")
    private String requestType;

    @ManyToMany
    private List<RoleMenu> roleMenus;
}
