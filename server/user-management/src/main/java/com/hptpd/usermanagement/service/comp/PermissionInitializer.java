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
        menuVos.add(simulateMapMenu(true));
        menuVos.add(simulateRealTimeMenu(true));
        menuVos.add(simulateHistoryMenu(true));
        menuVos.add(simulateControlMenu(true));
        menuVos.add(simulateMaintainingMenu(true, true));
        menuVos.add(simulateSurveillanceMenu(true, true));
        menuVos.add(simulateProcessingMenu(true, true));
        menuVos.add(simulateConfigurationMenu(true, true));
        menuVos.add(simulateDailyMenu(true, true));
        menuVos.add(simulateMonthlyMenu(true, true));
        menuVos.add(simulateAnalysisMenu(true));
        menuVos.add(simulateUserMenu(false, false));
        menuVos.add(simulateRoleMenu(false, false));
        menuVos.add(simulateLoggerMenu(false));
        return menuVos;
    }

    /**
     * 生成菜单和数据权限的基本结构
     *
     * @return
     */
    public static List<MenuVo> generateBaseMenu() {
        List<MenuVo> menuVos = Lists.newLinkedList();
        menuVos.add(simulateMapMenu(false));
        menuVos.add(simulateRealTimeMenu(false));
        menuVos.add(simulateHistoryMenu(false));
        menuVos.add(simulateControlMenu(false));
        menuVos.add(simulateMaintainingMenu(false, false));
        menuVos.add(simulateSurveillanceMenu(false, false));
        menuVos.add(simulateProcessingMenu(false, false));
        menuVos.add(simulateConfigurationMenu(false, false));
        menuVos.add(simulateDailyMenu(false, false));
        menuVos.add(simulateMonthlyMenu(false, false));
        menuVos.add(simulateAnalysisMenu(false));
        menuVos.add(simulateUserMenu(false, false));
        menuVos.add(simulateRoleMenu(false, false));
        menuVos.add(simulateLoggerMenu(false));
        return menuVos;
    }

    private static MenuVo simulateMapMenu(Boolean checked) {
        MenuVo mapMenu = new MenuVo();
        mapMenu.setName(PermissionConstant.MAP_NAME);
        mapMenu.setLabel(PermissionConstant.MAP_LABEL);
        mapMenu.setPath(PermissionConstant.MAP_PATH);
        mapMenu.setChecked(checked);
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

    private static MenuVo simulateRealTimeMenu(Boolean checked) {
        MenuVo realTimeMenu = new MenuVo();
        realTimeMenu.setName(PermissionConstant.REALTIME_NAME);
        realTimeMenu.setLabel(PermissionConstant.REALTIME_LABEL);
        realTimeMenu.setPath(PermissionConstant.REALTIME_PATH);
        realTimeMenu.setChecked(checked);
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

    private static MenuVo simulateHistoryMenu(Boolean checked) {
        MenuVo historyMenu = new MenuVo();
        historyMenu.setName(PermissionConstant.HISTORY_NAME);
        historyMenu.setLabel(PermissionConstant.HISTORY_LABEL);
        historyMenu.setPath(PermissionConstant.HISTORY_PATH);
        historyMenu.setChecked(checked);
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

    private static MenuVo simulateControlMenu(Boolean checked) {
        MenuVo controlMenu = new MenuVo();
        controlMenu.setName(PermissionConstant.CONTROL_NAME);
        controlMenu.setLabel(PermissionConstant.CONTROL_LABEL);
        controlMenu.setPath(PermissionConstant.CONTROL_PATH);
        controlMenu.setChecked(checked);
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

    private static MenuVo simulateMaintainingMenu(Boolean checked, Boolean dataChecked) {
        MenuVo maintainingMenu = new MenuVo();
        maintainingMenu.setName(PermissionConstant.MAINTAINING_NAME);
        maintainingMenu.setLabel(PermissionConstant.MAINTAINING_LABEL);
        maintainingMenu.setPath(PermissionConstant.MAINTAINING_PATH);
        maintainingMenu.setChecked(checked);
        List<DataVo> maintainingData = Lists.newLinkedList();
        maintainingData.add(DataVo.getEditPermission
                (PermissionConstant.MAINTAINING_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
        maintainingData.add(DataVo.getExportPermission
                (PermissionConstant.MAINTAINING_NAME + ":" + PermissionConstant.EXPORT_NAME, dataChecked));
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

    private static MenuVo simulateSurveillanceMenu(Boolean checked, Boolean dataChecked) {
        MenuVo surveillanceMenu = new MenuVo();
        surveillanceMenu.setName(PermissionConstant.SURVEILLANCE_NAME);
        surveillanceMenu.setLabel(PermissionConstant.SURVEILLANCE_LABEL);
        surveillanceMenu.setPath(PermissionConstant.SURVEILLANCE_PATH);
        surveillanceMenu.setChecked(checked);
        List<DataVo> surveillanceData = Lists.newLinkedList();
        surveillanceData.add(DataVo.getEditPermission
                (PermissionConstant.SURVEILLANCE_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
        surveillanceData.add(DataVo.getExportPermission
                (PermissionConstant.SURVEILLANCE_NAME + ":" + PermissionConstant.EXPORT_NAME, dataChecked));
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

    private static MenuVo simulateProcessingMenu(Boolean checked, Boolean dataChecked) {
        MenuVo processingMenu = new MenuVo();
        processingMenu.setName(PermissionConstant.PROCESSING_NAME);
        processingMenu.setLabel(PermissionConstant.PROCESSING_LABEL);
        processingMenu.setPath(PermissionConstant.PROCESSING_PATH);
        processingMenu.setChecked(checked);
        List<DataVo> processingData = Lists.newLinkedList();
        processingData.add(DataVo.getEditPermission
                (PermissionConstant.PROCESSING_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
        processingData.add(DataVo.getExportPermission
                (PermissionConstant.PROCESSING_NAME + ":" + PermissionConstant.EXPORT_NAME, dataChecked));
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

    private static MenuVo simulateConfigurationMenu(Boolean checked, Boolean dataChecked) {
        MenuVo configMenu = new MenuVo();
        configMenu.setName(PermissionConstant.CONFIGURATION_NAME);
        configMenu.setLabel(PermissionConstant.CONFIGURATION_LABEL);
        configMenu.setPath(PermissionConstant.CONFIGURATION_PATH);
        configMenu.setChecked(checked);
        List<DataVo> configData = Lists.newLinkedList();
        configData.add(DataVo.getRemovePermission
                (PermissionConstant.CONFIGURATION_NAME + ":" + PermissionConstant.REMOVE_NAME, dataChecked));
        configData.add(DataVo.getAddPermission
                (PermissionConstant.CONFIGURATION_NAME + ":" + PermissionConstant.ADD_NAME, dataChecked));
        configData.add(DataVo.getEditPermission
                (PermissionConstant.CONFIGURATION_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
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

    private static MenuVo simulateDailyMenu(Boolean checked, Boolean dataChecked) {
        MenuVo dailyMenu = new MenuVo();
        dailyMenu.setName(PermissionConstant.DAILY_NAME);
        dailyMenu.setLabel(PermissionConstant.DAILY_LABEL);
        dailyMenu.setPath(PermissionConstant.DAILY_PATH);
        dailyMenu.setChecked(checked);
        List<DataVo> dailyData = Lists.newLinkedList();
        dailyData.add(DataVo.getExportPermission
                (PermissionConstant.DAILY_NAME + ":" + PermissionConstant.EXPORT_NAME, dataChecked));
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

    private static MenuVo simulateMonthlyMenu(Boolean checked, Boolean dataChecked) {
        MenuVo monthlyMenu = new MenuVo();
        monthlyMenu.setName(PermissionConstant.MONTHLY_NAME);
        monthlyMenu.setLabel(PermissionConstant.MONTHLY_LABEL);
        monthlyMenu.setPath(PermissionConstant.MONTHLY_PATH);
        monthlyMenu.setChecked(checked);
        List<DataVo> monthlyData = Lists.newLinkedList();
        monthlyData.add(DataVo.getExportPermission
                (PermissionConstant.MONTHLY_NAME + ":" + PermissionConstant.EXPORT_NAME, dataChecked));
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

    private static MenuVo simulateAnalysisMenu(Boolean checked) {
        MenuVo analysisMenu = new MenuVo();
        analysisMenu.setName(PermissionConstant.ANALYSIS_NAME);
        analysisMenu.setLabel(PermissionConstant.ANALYSIS_LABEL);
        analysisMenu.setPath(PermissionConstant.ANALYSIS_PATH);
        analysisMenu.setChecked(checked);
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

    private static MenuVo simulateUserMenu(Boolean checked, Boolean dataChecked) {
        MenuVo userMenu = new MenuVo();
        userMenu.setName(PermissionConstant.USER_NAME);
        userMenu.setLabel(PermissionConstant.USER_LABEL);
        userMenu.setPath(PermissionConstant.USER_PATH);
        userMenu.setChecked(checked);
        List<DataVo> userData = Lists.newLinkedList();
        userData.add(DataVo.getRemovePermission
                (PermissionConstant.USER_NAME + ":" + PermissionConstant.REMOVE_NAME, dataChecked));
        userData.add(DataVo.getAddPermission
                (PermissionConstant.USER_NAME + ":" + PermissionConstant.ADD_NAME, dataChecked));
        userData.add(DataVo.getEditPermission
                (PermissionConstant.USER_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
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

    private static MenuVo simulateRoleMenu(Boolean checked, Boolean dataChecked) {
        MenuVo roleMenu = new MenuVo();
        roleMenu.setName(PermissionConstant.ROLE_NAME);
        roleMenu.setLabel(PermissionConstant.ROLE_LABEL);
        roleMenu.setPath(PermissionConstant.ROLE_PATH);
        roleMenu.setChecked(checked);
        List<DataVo> roleData = Lists.newLinkedList();
        roleData.add(DataVo.getAddPermission
                (PermissionConstant.ROLE_NAME + ":" + PermissionConstant.REMOVE_NAME, dataChecked));
        roleData.add(DataVo.getAddPermission
                (PermissionConstant.ROLE_NAME + ":" + PermissionConstant.ADD_NAME, dataChecked));
        roleData.add(DataVo.getEditPermission
                (PermissionConstant.ROLE_NAME + ":" + PermissionConstant.EDIT_NAME, dataChecked));
        roleData.add(DataVo.getGrantPermission
                (PermissionConstant.ROLE_NAME + ":" + PermissionConstant.GRANT_NAME, dataChecked));
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

    private static MenuVo simulateLoggerMenu(Boolean checked) {
        MenuVo loggerMenu = new MenuVo();
        loggerMenu.setName(PermissionConstant.LOGGER_NAME);
        loggerMenu.setLabel(PermissionConstant.LOGGER_LABEL);
        loggerMenu.setPath(PermissionConstant.LOGGER_PATH);
        loggerMenu.setChecked(checked);
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
        dataPermissions.add(maintainingEditOperation());
        dataPermissions.add(maintainingExportOperation());
        dataPermissions.add(surveillanceEditOperation());
        dataPermissions.add(surveillanceExportOperation());
        dataPermissions.add(processingEditOperation());
        dataPermissions.add(processingExportOperation());
        dataPermissions.add(configRemoveOperation());
        dataPermissions.add(configAddOperation());
        dataPermissions.add(configEditOperation());
        dataPermissions.add(dailyExportOperation());
        dataPermissions.add(monthlyExportOperation());
        dataPermissions.add(userRemoveOperation());
        dataPermissions.add(userAddOperation());
        dataPermissions.add(userEditOperation());
        dataPermissions.add(roleRemoveOperation());
        dataPermissions.add(roleAddOperation());
        dataPermissions.add(roleEditOperation());
        dataPermissions.add(roleGrantOperation());
        return dataPermissions;
    }

    private DataPermission maintainingEditOperation() {
        return addEditOperation(PermissionConstant.MAINTAINING_NAME);
    }

    private DataPermission maintainingExportOperation() {
        return addExportOperation(PermissionConstant.MAINTAINING_NAME);
    }

    private DataPermission surveillanceEditOperation() {
        return addEditOperation(PermissionConstant.SURVEILLANCE_NAME);
    }

    private DataPermission surveillanceExportOperation() {
        return addExportOperation(PermissionConstant.SURVEILLANCE_NAME);
    }

    private DataPermission processingEditOperation() {
        return addEditOperation(PermissionConstant.PROCESSING_NAME);
    }

    private DataPermission processingExportOperation() {
        return addExportOperation(PermissionConstant.PROCESSING_NAME);
    }

    private DataPermission configRemoveOperation() {
        return addRemoveOperation(PermissionConstant.CONFIGURATION_NAME);
    }

    private DataPermission configAddOperation() {
        return addAddOperation(PermissionConstant.CONFIGURATION_NAME);
    }

    private DataPermission configEditOperation() {
        return addEditOperation(PermissionConstant.CONFIGURATION_NAME);
    }

    private DataPermission dailyExportOperation() {
        return addExportOperation(PermissionConstant.DAILY_NAME);
    }

    private DataPermission monthlyExportOperation() {
        return addExportOperation(PermissionConstant.MONTHLY_NAME);
    }

    private DataPermission userRemoveOperation() {
        return addRemoveOperation(PermissionConstant.USER_NAME);
    }

    private DataPermission userAddOperation() {
        return addAddOperation(PermissionConstant.USER_NAME);
    }

    private DataPermission userEditOperation() {
        return addEditOperation(PermissionConstant.USER_NAME);
    }

    private DataPermission roleRemoveOperation() {
        return addRemoveOperation(PermissionConstant.ROLE_NAME);
    }

    private DataPermission roleAddOperation() {
        return addAddOperation(PermissionConstant.ROLE_NAME);
    }

    private DataPermission roleEditOperation() {
        return addEditOperation(PermissionConstant.ROLE_NAME);
    }

    private DataPermission roleGrantOperation() {
        return addGrantPermission(PermissionConstant.ROLE_NAME);
    }

    private DataPermission addEditOperation(String menuName) {
        DataPermission edit = new DataPermission();
        edit.setId(menuName + ":" + PermissionConstant.EDIT_NAME);
        edit.setName(PermissionConstant.EDIT_NAME);
        edit.setLabel(PermissionConstant.EDIT_LABEL);
        return dataPermissionRep.save(edit);
    }

    private DataPermission addAddOperation(String menuName) {
        DataPermission add = new DataPermission();
        add.setName(PermissionConstant.ADD_NAME);
        add.setId(menuName + ":" + PermissionConstant.ADD_NAME);
        add.setLabel(PermissionConstant.ADD_LABEL);
        return dataPermissionRep.save(add);
    }

    private DataPermission addRemoveOperation(String menuName) {
        DataPermission remove = new DataPermission();
        remove.setName(PermissionConstant.REMOVE_NAME);
        remove.setId(menuName + ":" + PermissionConstant.REMOVE_NAME);
        remove.setLabel(PermissionConstant.REMOVE_LABEL);
        return dataPermissionRep.save(remove);
    }

    private DataPermission addExportOperation(String menuName) {
        DataPermission export = new DataPermission();
        export.setId(menuName + ":" + PermissionConstant.EXPORT_NAME);
        export.setName(PermissionConstant.EXPORT_NAME);
        export.setLabel(PermissionConstant.EXPORT_LABEL);
        return dataPermissionRep.save(export);
    }

    private DataPermission addGrantPermission(String menuName) {
        DataPermission grant = new DataPermission();
        grant.setId(menuName + ":" + PermissionConstant.GRANT_NAME);
        grant.setName(PermissionConstant.GRANT_NAME);
        grant.setLabel(PermissionConstant.GRANT_LABEL);
        return dataPermissionRep.save(grant);
    }
}
