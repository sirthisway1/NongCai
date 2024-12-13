package cainong.jimi.controller;

import cainong.jimi.entity.User;
import cainong.jimi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        boolean isRegistered = userService.register(username, password);
        Map<String, Object> response = new HashMap<>();
        response.put("success", isRegistered);
        if (!isRegistered) {
            response.put("message", "注册失败");
        }
        return response;
    }

    // 获取用户所有信息
    @GetMapping("/info/{userID}")
    public User getUserInfo(@PathVariable String userID) {
        return userService.getUserInfo(userID);
    }
}