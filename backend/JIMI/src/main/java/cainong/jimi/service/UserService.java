package cainong.jimi.service;

import cainong.jimi.entity.User;

public interface UserService {

    /**
     * 登录方法，根据用户名和密码进行验证
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户信息，若失败返回 null
     */
    String login(String username, String password);

    boolean register(String username,String password);

    User getUserInfo(String userID);
}
