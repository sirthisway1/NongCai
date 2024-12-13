package cainong.jimi.service.impl;

import cainong.jimi.entity.Forum;
import cainong.jimi.mapper.ForumMapper;
import cainong.jimi.service.ForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements ForumService {

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

    // 创建新的帖子
    @Override
    public boolean createForum(String title, String content, String type, String username) {
        // 创建新的 Forum 对象
        Forum forum = new Forum();
        forum.setForumTitle(title);
        forum.setForumContent(content);
        forum.setForumType(type);
        forum.setForumUsername(username);
        forum.setForumTime(new java.sql.Timestamp(System.currentTimeMillis()).toString()); // 当前时间
        forum.setForumAmount("0"); // 默认帖子评论数为 0
        forum.setForumImg(""); // 默认图片为空

        // 保存到数据库
        return save(forum);
    }
}