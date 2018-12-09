package com.hptpd.usermanagement.service.comp;

import com.google.common.collect.Lists;
import com.hptpd.usermanagement.common.PermissionConstant;
import com.hptpd.usermanagement.domain.DataPermission;
import com.hptpd.usermanagement.domain.MenuPermission;
import com.hptpd.usermanagement.repository.DataPermissionRep;
import com.hptpd.usermanagement.repository.MenuPermissionRep;
import com.hptpd.usermanagement.vo.role.DataVo;
import com.hptpd.usermanagement.vo.role.MenuVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/8
 * \* @time: 0:01
 * \* Description: 权限初始化类（负责系统权限的整体初始化工作）
 * 其中包括所有菜单权限项和数据权限项的初始化工作
 * \
 */
@Component("permissionInitializer")
public class PermissionInitializer {

    @Resource(name = "menuPermissionRep")
    private MenuPermissionRep menuPermissionRep;

    @Resource(name = "dataPermissionRep")
    private DataPermissionRep dataPermissionRep;

    public List<MenuPermission> menuPermissionInit() {
        List<MenuPermission> menuPermissions = Lists.newLinkedList();
        menuPermissions.add(addMapMenu());
        menuPermissions.add(addRealTimeMenu());
        menuPermissions.add(addHistoryMenu());
        menuPermissions.add(addControlMenu());
        menuPermissions.add(addMaintainingMenu());
        menuPermissions.add(addSurveillanceMenu());
        menuPermissions.add(addProcessingMenu());
        menuPermissions.add(addConfigurationMenu());
        menuPermissions.add(addDailyMenu());
        menuPermissions.add(addMonthlyMenu());
        menuPermissions.add(addAnalysisMenu());
        menuPermissions.add(addUserMenu());
        menuPermissions.add(addRoleMenu());
        menuPermissions.add(addLoggerMenu());
        return menuPermissions;
    }

    public List<MenuVo> simulateTestMenuData() {
        List<MenuVo> menuVos = Lists.newLinkedList();
        menuVos.add(simulateMapMenu());
        menuVos.add(simulateRealTimeMenu());
        menuVos.add(simulateHistoryMenu());
        menuVos.add(simulateControlMenu());
        menuVos.add(simulateMaintainingMenu());
        menuVos.add(simulateSurveillanceMenu());
        menuVos.add(simulateProcessingMenu());
        menuVos.add(simulateConfigurationMenu());
        menuVos.add(simulateDailyMenu());
        menuVos.add(simulateMonthlyMenu());
        menuVos.add(simulateAnalysisMenu());
        menuVos.add(simulateUserMenu());
        menuVos.add(simulateRoleMenu());
        menuVos.add(simulateLoggerMenu());
        return menuVos;
    }

    private MenuVo simulateMapMenu() {
        MenuVo mapMenu = new MenuVo();
        mapMenu.setName(PermissionConstant.MAP_NAME);
        mapMenu.setLabel(PermissionConstant.MAP_LABEL);
        mapMenu.setPath(PermissionConstant.MAP_PATH);
        mapMenu.setChecked(true);
        List<DataVo> mapData = Lists.newLinkedList();
        mapMenu.setPermission(mapData);
        return mapMenu;
    }

    private MenuPermission addMapMenu() {
        MenuPermission mapMenu = new MenuPermission();
        mapMenu.setName(PermissionConstant.MAP_NAME);
        mapMenu.setLabel(PermissionConstant.MAP_LABEL);
        mapMenu.setPath(PermissionConstant.MAP_PATH);
        return menuPermissionRep.save(mapMenu);
    }

    private MenuVo simulateRealTimeMenu() {
        MenuVo realTimeMenu = new MenuVo();
        realTimeMenu.setName(PermissionConstant.REALTIME_NAME);
        realTimeMenu.setLabel(PermissionConstant.REALTIME_LABEL);
        realTimeMenu.setPath(PermissionConstant.REALTIME_PATH);
        realTimeMenu.setChecked(true);
        List<DataVo> realTimeData = Lists.newLinkedList();
        realTimeMenu.setPermission(realTimeData);
        return realTimeMenu;
    }

    private MenuPermission addRealTimeMenu() {
        MenuPermission realTimeMenu = new MenuPermission();
        realTimeMenu.setName(PermissionConstant.REALTIME_NAME);
        realTimeMenu.setLabel(PermissionConstant.REALTIME_LABEL);
        realTimeMenu.setPath(PermissionConstant.REALTIME_PATH);
        return menuPermissionRep.save(realTimeMenu);
    }

    private MenuVo simulateHistoryMenu() {
        MenuVo historyMenu = new MenuVo();
        historyMenu.setName(PermissionConstant.HISTORY_NAME);
        historyMenu.setLabel(PermissionConstant.HISTORY_LABEL);
        historyMenu.setPath(PermissionConstant.HISTORY_PATH);
        historyMenu.setChecked(true);
        List<DataVo> historyData = Lists.newLinkedList();
        historyMenu.setPermission(historyData);
        return historyMenu;
    }

    private MenuPermission addHistoryMenu() {
        MenuPermission historyMenu = new MenuPermission();
        historyMenu.setName(PermissionConstant.HISTORY_NAME);
        historyMenu.setLabel(PermissionConstant.HISTORY_LABEL);
        historyMenu.setPath(PermissionConstant.HISTORY_PATH);
        return menuPermissionRep.save(historyMenu);
    }

    private MenuVo simulateControlMenu() {
        MenuVo controlMenu = new MenuVo();
        controlMenu.setName(PermissionConstant.CONTROL_NAME);
        controlMenu.setLabel(PermissionConstant.CONTROL_LABEL);
        controlMenu.setPath(PermissionConstant.CONTROL_PATH);
        controlMenu.setChecked(true);
        List<DataVo> controlData = Lists.newLinkedList();
        controlMenu.setPermission(controlData);
        return controlMenu;
    }

    private MenuPermission addControlMenu() {
        MenuPermission controlMenu = new MenuPermission();
        controlMenu.setName(PermissionConstant.CONTROL_NAME);
        controlMenu.setLabel(PermissionConstant.CONTROL_LABEL);
        controlMenu.setPath(PermissionConstant.CONTROL_PATH);
        return menuPermissionRep.save(controlMenu);
    }

    private MenuVo simulateMaintainingMenu() {
        MenuVo maintainingMenu = new MenuVo();
        maintainingMenu.setName(PermissionConstant.MAINTAINING_NAME);
        maintainingMenu.setLabel(PermissionConstant.MAINTAINING_LABEL);
        maintainingMenu.setPath(PermissionConstant.MAINTAINING_PATH);
        maintainingMenu.setChecked(false);
        List<DataVo> maintainingData = Lists.newLinkedList();
        maintainingData.add(DataVo.getEditPermission(true));
        maintainingData.add(DataVo.getExportPermission(true));
        maintainingMenu.setPermission(maintainingData);
        return maintainingMenu;
    }

    private MenuPermission addMaintainingMenu() {
        MenuPermission maintainingMenu = new MenuPermission();
        maintainingMenu.setName(PermissionConstant.MAINTAINING_NAME);
        maintainingMenu.setLabel(PermissionConstant.MAINTAINING_LABEL);
        maintainingMenu.setPath(PermissionConstant.MAINTAINING_PATH);
        return menuPermissionRep.save(maintainingMenu);
    }

    private MenuVo simulateSurveillanceMenu() {
        MenuVo surveillanceMenu = new MenuVo();
        surveillanceMenu.setName(PermissionConstant.SURVEILLANCE_NAME);
        surveillanceMenu.setLabel(PermissionConstant.SURVEILLANCE_LABEL);
        surveillanceMenu.setPath(PermissionConstant.SURVEILLANCE_PATH);
        surveillanceMenu.setChecked(true);
        List<DataVo> surveillanceData = Lists.newLinkedList();
        surveillanceData.add(DataVo.getEditPermission(true));
        surveillanceData.add(DataVo.getExportPermission(true));
        surveillanceMenu.setPermission(surveillanceData);
        return surveillanceMenu;
    }

    private MenuPermission addSurveillanceMenu() {
        MenuPermission surveillanceMenu = new MenuPermission();
        surveillanceMenu.setName(PermissionConstant.SURVEILLANCE_NAME);
        surveillanceMenu.setLabel(PermissionConstant.SURVEILLANCE_LABEL);
        surveillanceMenu.setPath(PermissionConstant.SURVEILLANCE_PATH);
        return menuPermissionRep.save(surveillanceMenu);
    }

    private MenuVo simulateProcessingMenu() {
        MenuVo processingMenu = new MenuVo();
        processingMenu.setName(PermissionConstant.PROCESSING_NAME);
        processingMenu.setLabel(PermissionConstant.PROCESSING_LABEL);
        processingMenu.setPath(PermissionConstant.PROCESSING_PATH);
        processingMenu.setChecked(true);
        List<DataVo> processingData = Lists.newLinkedList();
        processingData.add(DataVo.getEditPermission(true));
        processingData.add(DataVo.getExportPermission(true));
        processingMenu.setPermission(processingData);
        return processingMenu;
    }

    private MenuPermission addProcessingMenu() {
        MenuPermission processingMenu = new MenuPermission();
        processingMenu.setName(PermissionConstant.PROCESSING_NAME);
        processingMenu.setLabel(PermissionConstant.PROCESSING_LABEL);
        processingMenu.setPath(PermissionConstant.PROCESSING_PATH);
        return menuPermissionRep.save(processingMenu);
    }

    private MenuVo simulateConfigurationMenu() {
        MenuVo configMenu = new MenuVo();
        configMenu.setName(PermissionConstant.CONFIGURATION_NAME);
        configMenu.setLabel(PermissionConstant.CONFIGURATION_LABEL);
        configMenu.setPath(PermissionConstant.CONFIGURATION_PATH);
        configMenu.setChecked(true);
        List<DataVo> configData = Lists.newLinkedList();
        configData.add(DataVo.getRemovePermission(true));
        configData.add(DataVo.getAddPermission(true));
        configData.add(DataVo.getEditPermission(true));
        configMenu.setPermission(configData);
        return configMenu;
    }

    private MenuPermission addConfigurationMenu() {
        MenuPermission configMenu = new MenuPermission();
        configMenu.setName(PermissionConstant.CONFIGURATION_NAME);
        configMenu.setLabel(PermissionConstant.CONFIGURATION_LABEL);
        configMenu.setPath(PermissionConstant.CONFIGURATION_PATH);
        return menuPermissionRep.save(configMenu);
    }

    private MenuVo simulateDailyMenu() {
        MenuVo dailyMenu = new MenuVo();
        dailyMenu.setName(PermissionConstant.DAILY_NAME);
        dailyMenu.setLabel(PermissionConstant.DAILY_LABEL);
        dailyMenu.setPath(PermissionConstant.DAILY_PATH);
        dailyMenu.setChecked(true);
        List<DataVo> dailyData = Lists.newLinkedList();
        dailyData.add(DataVo.getExportPermission(true));
        dailyMenu.setPermission(dailyData);
        return dailyMenu;
    }

    private MenuPermission addDailyMenu() {
        MenuPermission dailyMenu = new MenuPermission();
        dailyMenu.setName(PermissionConstant.DAILY_NAME);
        dailyMenu.setLabel(PermissionConstant.DAILY_LABEL);
        dailyMenu.setPath(PermissionConstant.DAILY_PATH);
        return menuPermissionRep.save(dailyMenu);
    }

    private MenuVo simulateMonthlyMenu() {
        MenuVo monthlyMenu = new MenuVo();
        monthlyMenu.setName(PermissionConstant.MONTHLY_NAME);
        monthlyMenu.setLabel(PermissionConstant.MONTHLY_LABEL);
        monthlyMenu.setPath(PermissionConstant.MONTHLY_PATH);
        monthlyMenu.setChecked(true);
        List<DataVo> monthlyData = Lists.newLinkedList();
        monthlyData.add(DataVo.getExportPermission(true));
        monthlyMenu.setPermission(monthlyData);
        return monthlyMenu;
    }

    private MenuPermission addMonthlyMenu() {
        MenuPermission monthlyMenu = new MenuPermission();
        monthlyMenu.setName(PermissionConstant.MONTHLY_NAME);
        monthlyMenu.setLabel(PermissionConstant.MONTHLY_LABEL);
        monthlyMenu.setPath(PermissionConstant.MONTHLY_PATH);
        return menuPermissionRep.save(monthlyMenu);
    }

    private MenuVo simulateAnalysisMenu() {
        MenuVo analysisMenu = new MenuVo();
        analysisMenu.setName(PermissionConstant.ANALYSIS_NAME);
        analysisMenu.setLabel(PermissionConstant.ANALYSIS_LABEL);
        analysisMenu.setPath(PermissionConstant.ANALYSIS_PATH);
        analysisMenu.setChecked(true);
        List<DataVo> analysisData = Lists.newLinkedList();
        analysisMenu.setPermission(analysisData);
        return analysisMenu;
    }

    private MenuPermission addAnalysisMenu() {
        MenuPermission analysisMenu = new MenuPermission();
        analysisMenu.setName(PermissionConstant.ANALYSIS_NAME);
        analysisMenu.setLabel(PermissionConstant.ANALYSIS_LABEL);
        analysisMenu.setPath(PermissionConstant.ANALYSIS_PATH);
        return menuPermissionRep.save(analysisMenu);
    }

    private MenuVo simulateUserMenu() {
        MenuVo userMenu = new MenuVo();
        userMenu.setName(PermissionConstant.USER_NAME);
        userMenu.setLabel(PermissionConstant.USER_LABEL);
        userMenu.setPath(PermissionConstant.USER_PATH);
        userMenu.setChecked(true);
        List<DataVo> userData = Lists.newLinkedList();
        userData.add(DataVo.getRemovePermission(true));
        userData.add(DataVo.getAddPermission(true));
        userData.add(DataVo.getEditPermission(true));
        userMenu.setPermission(userData);
        return userMenu;
    }

    private MenuPermission addUserMenu() {
        MenuPermission userMenu = new MenuPermission();
        userMenu.setName(PermissionConstant.USER_NAME);
        userMenu.setLabel(PermissionConstant.USER_LABEL);
        userMenu.setPath(PermissionConstant.USER_PATH);
        return menuPermissionRep.save(userMenu);
    }

    private MenuVo simulateRoleMenu() {
        MenuVo roleMenu = new MenuVo();
        roleMenu.setName(PermissionConstant.ROLE_NAME);
        roleMenu.setLabel(PermissionConstant.ROLE_LABEL);
        roleMenu.setPath(PermissionConstant.ROLE_PATH);
        roleMenu.setChecked(true);
        List<DataVo> roleData = Lists.newLinkedList();
        roleData.add(DataVo.getAddPermission(true));
        roleData.add(DataVo.getEditPermission(true));
        roleData.add(DataVo.getGrantPermission(true));
        roleMenu.setPermission(roleData);
        return roleMenu;
    }

    private MenuPermission addRoleMenu() {
        MenuPermission roleMenu = new MenuPermission();
        roleMenu.setName(PermissionConstant.ROLE_NAME);
        roleMenu.setLabel(PermissionConstant.ROLE_LABEL);
        roleMenu.setPath(PermissionConstant.ROLE_PATH);
        return menuPermissionRep.save(roleMenu);
    }

    private MenuVo simulateLoggerMenu() {
        MenuVo loggerMenu = new MenuVo();
        loggerMenu.setName(PermissionConstant.LOGGER_NAME);
        loggerMenu.setLabel(PermissionConstant.LOGGER_LABEL);
        loggerMenu.setPath(PermissionConstant.LOGGER_PATH);
        loggerMenu.setChecked(true);
        List<DataVo> loggerData = Lists.newLinkedList();
        loggerMenu.setPermission(loggerData);
        return loggerMenu;
    }

    private MenuPermission addLoggerMenu() {
        MenuPermission loggerMenu = new MenuPermission();
        loggerMenu.setName(PermissionConstant.LOGGER_NAME);
        loggerMenu.setLabel(PermissionConstant.LOGGER_LABEL);
        loggerMenu.setPath(PermissionConstant.LOGGER_PATH);
        return menuPermissionRep.save(loggerMenu);
    }

    public List<DataPermission> dataPermissionInit() {
        List<DataPermission> dataPermissions = Lists.newLinkedList();
        dataPermissions.add(addEditOperation());
        dataPermissions.add(addAddOperation());
        dataPermissions.add(addRemoveOperation());
        dataPermissions.add(addExportOperation());
        return dataPermissions;
    }

    private DataPermission addEditOperation() {
        DataPermission edit = new DataPermission();
        edit.setName(PermissionConstant.EDIT_NAME);
        edit.setLabel(PermissionConstant.EDIT_LABEL);
        return dataPermissionRep.save(edit);
    }

    private DataPermission addAddOperation() {
        DataPermission add = new DataPermission();
        add.setName(PermissionConstant.ADD_NAME);
        add.setLabel(PermissionConstant.ADD_LABEL);
        return dataPermissionRep.save(add);
    }

    private DataPermission addRemoveOperation() {
        DataPermission remove = new DataPermission();
        remove.setName(PermissionConstant.REMOVE_NAME);
        remove.setLabel(PermissionConstant.REMOVE_LABEL);
        return dataPermissionRep.save(remove);
    }

    private DataPermission addExportOperation() {
        DataPermission export = new DataPermission();
        export.setName(PermissionConstant.EXPORT_NAME);
        export.setLabel(PermissionConstant.EXPORT_LABEL);
        return dataPermissionRep.save(export);
    }
}
