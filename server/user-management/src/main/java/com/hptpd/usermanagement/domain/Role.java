package com.hptpd.usermanagement.domain;

import com.google.common.collect.Sets;
import com.hptpd.usermanagement.domain.user.User;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 11:14
 * \* Description: 角色类
 * \
 */
@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "role")
    private Set<User> users = Sets.newLinkedHashSet();

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleMenu> roleMenus = Sets.newLinkedHashSet();

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Role role = (Role) o;

        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
