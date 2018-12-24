package com.hptpd.sewageservice.domain.system;

import lombok.Data;

import javax.persistence.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/24
 * \* @time: 14:48
 * \* Description: 集成商系统基类
 * \
 */
@Entity
@Table(name = "integration_system")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
@Data
public abstract class BaseIntegrationSystem {

    @Id
    private String systemCode;

    private String name;


}
