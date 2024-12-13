package cainong.jimi.service.impl;

import cainong.jimi.entity.User;
import cainong.jimi.mapper.UserMapper;
import cainong.jimi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);  // 添加用户名查询条件
        User user = userMapper.selectOne(queryWrapper);  // 查询单个用户

        // 检查密码是否匹配
        if (user != null && user.getPassword().equals(password)) {
            return user.getUserID();  // 登录成功，返回用户ID
        }
        return null;  // 登录失败，返回 null
    }

    @Override
    public boolean register(String username, String password) {
        // 使用 QueryWrapper 构建查询条件，检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);  // 添加用户名查询条件
        User existingUser = userMapper.selectOne(queryWrapper);

        if (existingUser != null) {
            return false;  // 用户名已存在，返回 false
        }

        // 创建新用户对象
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        // 插入新用户到数据库
        int rows = userMapper.insert(newUser);
        return rows > 0;  // 如果插入成功，返回 true
    }

    // 根据 userID 查询用户所有信息
    @Override
    public User getUserInfo(String userID) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userID", userID);
        return userMapper.selectOne(queryWrapper);
    }
}