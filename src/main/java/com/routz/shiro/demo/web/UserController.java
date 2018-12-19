package com.routz.shiro.demo.web;

import com.routz.shiro.demo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    /**
     * 不需要权限，但是需要session登录，或者带有token
     */
    @RequestMapping("/unnauth")
    public String unnauth() {
        return "不需要访问权限的请求";
    }

    @RequestMapping("/nauth")
    @RequiresPermissions("user:book")
    public String nauth(String userId) {
        return "需要访问权限的请求";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    private UserService userService;
}
