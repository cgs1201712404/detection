package com.hptpd.usermanagement.vo.role;

import com.hptpd.usermanagement.domain.MenuPermission;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 2:32
 * \* Description: MenuPermission ViewObject类
 * \
 */
@Data
public class MenuVo {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单label
     */
    private String label;

    /**
     * 是否勾选
     */
    private Boolean checked = false;

    private List<DataVo> permission;

    public static MenuPermission toDo(MenuVo menuVo) {
        MenuPermission menuPermission = new MenuPermission();
        menuPermission.setName(menuVo.getName());
        menuPermission.setPath(menuVo.getPath());
        menuPermission.setLabel(menuVo.getLabel());
        return menuPermission;
    }

    public static MenuVo toVo(MenuPermission menuPermission) {
        MenuVo menuVo = new MenuVo();
        menuVo.setName(menuPermission.getName());
        menuVo.setLabel(menuPermission.getLabel());
        menuVo.setPath(menuPermission.getPath());
        return menuVo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuVo menuVo = (MenuVo) o;
        return Objects.equals(name, menuVo.name) &&
                Objects.equals(path, menuVo.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path);
    }
}
