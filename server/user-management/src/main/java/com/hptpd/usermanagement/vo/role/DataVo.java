package com.hptpd.usermanagement.vo.role;

import com.hptpd.usermanagement.common.PermissionConstant;
import com.hptpd.usermanagement.domain.DataPermission;
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

    public DataVo(String value, String label, String id, Boolean checked) {
        this.id = id;
        this.value = value;
        this.label = label;
        this.checked = checked;
    }

    private String id;

    private String value;

    /**
     * 数据操作label
     */
    private String label;

    /**
     * 数据操作url
     */
    private String url;

    /**
     * 是否勾选
     */
    private Boolean checked = false;

    public static DataVo toVo(DataPermission dataPermission) {
        DataVo dataVo = new DataVo();
        dataVo.setValue(dataPermission.getName());
        dataVo.setLabel(dataPermission.getLabel());
        dataVo.setUrl(dataPermission.getUrl());
        return dataVo;
    }

    public static DataVo getEditPermission(String id, Boolean checked) {
        return new DataVo(PermissionConstant.EDIT_NAME, PermissionConstant.EDIT_LABEL, id, checked);
    }

    public static DataVo getExportPermission(String id, Boolean checked) {
        return new DataVo(PermissionConstant.EXPORT_NAME, PermissionConstant.EXPORT_LABEL, id, checked);
    }

    public static DataVo getRemovePermission(String id, Boolean checked) {
        return new DataVo(PermissionConstant.REMOVE_NAME, PermissionConstant.REMOVE_LABEL, id, checked);
    }

    public static DataVo getAddPermission(String id, Boolean checked) {
        return new DataVo(PermissionConstant.ADD_NAME, PermissionConstant.ADD_LABEL, id, checked);
    }

    public static DataVo getGrantPermission(String id, Boolean checked) {
        return new DataVo(PermissionConstant.GRANT_NAME, PermissionConstant.GRANT_LABEL, id, checked);
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

        DataVo dataVo = (DataVo) o;

        return value.equals(dataVo.value) && url.equals(dataVo.url);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
