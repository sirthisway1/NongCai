package cainong.jimi.controller;

import cainong.jimi.entity.User;
import cainong.jimi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        String UserID = userService.login(username, password);
        return UserID;
    }

    // 注册
    @PostMapping("/register")
    public boolean register(@RequestParam String username, @RequestParam String password) {
        boolean isRegistered = userService.register(username,password);
        return isRegistered;
    }

    // 获取用户所有信息
    @GetMapping("/info/{userID}")
    public User getUserInfo(@PathVariable String userID) {
        return userService.getUserInfo(userID);
    }
}