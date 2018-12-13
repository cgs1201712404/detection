package com.hptpd.usermanagement.controller;

import com.hptpd.usermanagement.component.Result;
import com.hptpd.usermanagement.vo.user.UserPageVo;
import com.hptpd.usermanagement.vo.user.UserVo;
import com.hptpd.usermanagement.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 彭诗杰
 * \* @date: 2018/12/7
 * \* @time: 17:16
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/add.shtml", method = RequestMethod.POST)
    public Result addUser(@RequestBody UserVo userVo) {
        Result result = userService.addUserWithRole(userVo);
        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/{name}.json", method = RequestMethod.GET)
    public UserPageVo findByName(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 @PathVariable String name) {
        UserPageVo userPageVo = userService.findByName(name, PageRequest.of(page - 1, limit));
        logger.info(userPageVo.toString());
        return userPageVo;
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public UserPageVo getAllUsers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        UserPageVo userPageVo = userService.getAllUsers(PageRequest.of(page - 1, limit));
        logger.info(userPageVo.toString());
        return userPageVo;
    }

    @RequestMapping(value = "/remove/{name}.html", method = RequestMethod.GET)
    public Result removeUser(@PathVariable String name) {
        Result result = userService.removeUser(name);
        logger.info(result.toString());
        return result;
    }
}
