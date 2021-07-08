package com.example.demo.controller;

import com.example.demo.dao.modol.UserInfo;
import com.example.demo.result.ApiActionResult;
import com.example.demo.service.UserService;
import com.example.demo.util.StringsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 23:03
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ApiActionResult addUser(@RequestParam(value = "userName") String userName,
                                   @RequestParam(value = "tel") Integer tel,
                                   @RequestParam(value = "plate") String plate,
                                   @RequestParam(value = "distance") Long distance,
                                   @RequestParam(value = "service") String service) {
        log.info("userName is {},tel is {},plate is {},distance is {},service is {} ", userName, tel, plate, distance, service);
        try {
            userService.addUser(userName, tel, plate, distance, service);
            return ApiActionResult.newSuccess("添加成功");
        } catch (Exception e) {
            return ApiActionResult.newError(e.getMessage());
        }

    }

    @CrossOrigin
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ApiActionResult updateUser(@RequestParam(value = "userName") String userName,
                                      @RequestParam(value = "tel", required = false) Integer tel,
                                      @RequestParam(value = "plate", required = false) String plate,
                                      @RequestParam(value = "distance", required = false) Long distance,
                                      @RequestParam(value = "service", required = false) String service) {
        log.info("userName is {},tel is {},plate is {},distance is {},service is {} ", userName, tel, plate, distance, service);
        if (StringsUtil.isNullOrEmpty(userName)) {
            return ApiActionResult.newError("修改用户信息用户名不可以为空");
        }
        try {
            userService.updateUser(userName, tel, plate, distance, service);
            return ApiActionResult.newSuccess("修改成功");
        } catch (Exception e) {
            return ApiActionResult.newError(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ApiActionResult search(@RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "tel", required = false, defaultValue = "-1") Integer tel) {
        log.info("userName is {},tel is {} ", userName, tel);
        try {
            List<UserInfo> result = userService.searchList(userName, tel);
            return ApiActionResult.newSuccess(result);
        } catch (Exception e) {
            return ApiActionResult.newError(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ApiActionResult delete(@RequestParam(value = "userName") String userName) {
        log.info("userName is {} ", userName);
        try {
            userService.deleteByUser(userName);
            return ApiActionResult.newSuccess("删除成功");
        } catch (Exception e) {
            return ApiActionResult.newError(e.getMessage());
        }
    }
}
