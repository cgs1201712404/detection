package com.hptpd.usermanagement.domain;

import com.google.common.collect.Sets;
import com.hptpd.usermanagement.repository.RoleMenuRep;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/6
 * \* @time: 11:29
 * \* Description: 角色菜单中间实体
 * \
 */
@Entity
@Table(name = "role_menu")
@Data
public class RoleMenu {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    public RoleMenu(Role role, MenuPermission menuPermission) {
        this.role = role;
        this.menuPermission = menuPermission;
    }

    @ManyToOne
    private Role role;

    @ManyToOne(cascade = CascadeType.MERGE)
    private MenuPermission menuPermission;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<DataPermission> dataPermissions = Sets.newLinkedHashSet();

    private void removeMenuPermission(RoleMenuRep rep) {
        if (this.menuPermission != null) {
            this.menuPermission.getRoleMenus().remove(this);
            this.setMenuPermission(null);
        }
        rep.save(this);
    }

    private void removeAllDataPermissions(RoleMenuRep rep) {
        this.setDataPermissions(null);
        rep.save(this);
    }

    public void addDataPermission(DataPermission dataPermission) {
        this.getDataPermissions().add(dataPermission);
    }

    public void setMenuPermissionRelation(MenuPermission menuPermission) {
        this.setMenuPermission(menuPermission);
        menuPermission.getRoleMenus().add(this);
    }

    public void removeSelf(RoleMenuRep rep) {
        this.removeMenuPermission(rep);
        this.removeAllDataPermissions(rep);
        rep.delete(this);
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id='" + id + '\'' +
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

        RoleMenu roleMenu = (RoleMenu) o;

        return id.equals(roleMenu.id);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
