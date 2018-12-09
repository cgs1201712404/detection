package com.hptpd.usermanagement.vo.role;

import com.hptpd.usermanagement.common.PermissionConstant;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 2:36
 * \* Description: DataPermission ViewObject对象
 * \
 */
@Data
public class DataVo {

    public DataVo() {

    }

    private DataVo(String value, String label, Boolean checked) {
        this.value = value;
        this.label = label;
        this.checked = checked;
    }

    private String value;

    /**
     * 数据操作label
     */
    private String label;

    /**
     * 是否勾选
     */
    private Boolean checked = false;

    public static DataVo getEditPermission(Boolean checked) {
        return new DataVo(PermissionConstant.EDIT_NAME, PermissionConstant.EDIT_LABEL, checked);
    }

    public static DataVo getExportPermission(Boolean checked) {
        return new DataVo(PermissionConstant.EXPORT_NAME, PermissionConstant.EXPORT_LABEL, checked);
    }

    public static DataVo getRemovePermission(Boolean checked) {
        return new DataVo(PermissionConstant.REMOVE_NAME, PermissionConstant.REMOVE_LABEL, checked);
    }

    public static DataVo getAddPermission(Boolean checked) {
        return new DataVo(PermissionConstant.ADD_NAME, PermissionConstant.ADD_LABEL, checked);
    }

    public static DataVo getGrantPermission(Boolean checked) {
        return new DataVo(PermissionConstant.GRANT_NAME, PermissionConstant.GRANT_LABEL, checked);
    }
}
