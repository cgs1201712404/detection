package com.hptpd.usermanagement.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
public class DataPermission implements Serializable{

    @Id
    private String id;

    /**
     * 数据操作名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 数据操作label
     */
    @Column(name = "label")
    private String label;

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

}
