package com.hptpd.usermanagement.controller;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.service.IRoleService;
import com.hptpd.usermanagement.service.IUserService;
import com.hptpd.usermanagement.vo.IdName;
import com.hptpd.usermanagement.vo.role.RolePageVo;
import com.hptpd.usermanagement.vo.role.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/7
 * \* @time: 17:16
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private IRoleService roleService;

    @RequestMapping(value = "/add.shtml", method = RequestMethod.POST)
    public Result addRole(@RequestBody RoleVo roleVo) {
        Result result = roleService.addRoleDefault(roleVo);
        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/update.shtml", method = RequestMethod.POST)
    public Result updateRole(@RequestBody RoleVo roleVo) {
        Result result = roleService.updateRole(roleVo);
        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/remove/{id}.html", method = RequestMethod.GET)
    public Result removeRole(@PathVariable String id) {
        Result result = roleService.removeRole(id);
        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/batch/remove.shtml", method = RequestMethod.POST)
    public Result batchRemoveRoles(@RequestBody String[] ids) {
        Result result = roleService.batchRemoveRoles(ids);
        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public RolePageVo getAllRoles(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        RolePageVo rolePageVo = roleService.getAllRoles(PageRequest.of(page - 1, limit));
        logger.info(rolePageVo.toString());
        return rolePageVo;
    }

    @RequestMapping(value = "/id_name/list.json", method = RequestMethod.GET)
    public List<IdName> getAllRoles() {
        List<IdName> idNames = roleService.getAllRoles();
        logger.info(idNames.toString());
        return idNames;
    }

    @RequestMapping(value = "/auth.shtml", method = RequestMethod.POST)
    public Result grantPermissions(@RequestBody RoleVo roleVo) {
        Result result = roleService.grantPermissions(roleVo, roleVo.getPermissionGroup());
        logger.info(result.toString());
        return result;
    }

    /**
     * 通过角色id获取角色相关信息，包括角色的菜单权限和数据权限
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
    public Result getRoleById(@PathVariable String id) {
        Result result = roleService.findRoleById(id);
        logger.info(result.toString());
        return result;
    }
}
