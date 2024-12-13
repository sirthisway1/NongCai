package cainong.jimi.service.impl;

import cainong.jimi.entity.Forum;
import cainong.jimi.mapper.ForumMapper;
import cainong.jimi.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumMapper forumMapper;

    // 获取所有帖子
    @Override
    public List<Forum> getAllForums() {
        return forumMapper.selectList(null);  // 使用 MyBatis-Plus 的 selectList 查询所有数据
    }

    // 根据 forumID 获取指定帖子
    @Override
    public Forum getForumById(String forumID) {
        return forumMapper.selectById(forumID);
    }
}