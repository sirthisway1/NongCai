package cainong.jimi.service.impl;

import cainong.jimi.DTO.UserUpdateDTO;
import cainong.jimi.entity.User;
import cainong.jimi.mapper.UserMapper;
import cainong.jimi.mapper.VideoMapper;
import cainong.jimi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${video.upload-avator-dir}")
    private String uploadAvatorDir;

    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String downloadIp;

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

    @Override
    public String saveImg(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        // 创建上传目录（如果不存在）
        Path uploadPath = Paths.get(uploadAvatorDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 生成唯一文件名
        String fileFullName = generateUniqueFileName(file.getOriginalFilename());

        // 创建文件并保存
        File imageFile = new File(uploadAvatorDir + fileFullName);
        file.transferTo(imageFile);

        // 设置视频地址（HTTP形式）
        String uploadPathHttp = "http://" + downloadIp + ":" + port + "/avators/" + fileFullName;

        return uploadPathHttp;
    }

    // 获取文件扩展名
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private String generateUniqueFileName(String originalFilename) {
        // 生成 UUID 并去掉分隔符
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 获取文件扩展名
        String fileExtension = getFileExtension(originalFilename);
        // 截取 UUID 的部分字符串以确保总长度不超过32个字符
        String uniquePart = uuid.substring(0, Math.min(uuid.length(), 32 - fileExtension.length()));
        return uniquePart + fileExtension;
    }

    @Override
    public boolean updateUserInfo(UserUpdateDTO userUpdatedto) {
        // 查询数据库中的用户
        User user = userMapper.selectById(userUpdatedto.getUserID());
        if (user != null) {
            // 根据用户传入的表单数据更新用户信息
            user.setUsername(userUpdatedto.getUsername());
            user.setUserGender(userUpdatedto.getUserGender());
            user.setUserImg(userUpdatedto.getUserImg());
            user.setUserAddress(userUpdatedto.getUserAddress());
            user.setUserPhone(userUpdatedto.getUserPhone());
            user.setUserEmail(userUpdatedto.getUserEmail());

            // 执行更新操作
            int result = userMapper.updateById(user);
            return result > 0;  // 返回是否更新成功
        }
        return false;  // 用户不存在
    }

}