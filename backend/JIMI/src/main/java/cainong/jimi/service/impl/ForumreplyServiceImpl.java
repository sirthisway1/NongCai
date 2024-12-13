package cainong.jimi.service.impl;

import cainong.jimi.entity.Forumreply;
import cainong.jimi.mapper.ForumreplyMapper;
import cainong.jimi.service.ForumreplyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumreplyServiceImpl implements ForumreplyService {

    @Autowired
    private ForumreplyMapper forumreplyMapper;

    // 发布评论
    @Override
    public boolean postReply(Forumreply forumreply) {
        int result = forumreplyMapper.insert(forumreply); // 使用 MyBatis-Plus 的 insert 方法
        return result > 0;
    }

    // 根据 forumID 获取指定帖子的所有评论
    @Override
    public List<Forumreply> getRepliesByForumID(String forumID) {
        // 使用 LambdaQueryWrapper 来构建查询条件
        LambdaQueryWrapper<Forumreply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Forumreply::getReplyForumID, forumID); // 查询条件：根据 forumID 获取评论

        // 使用 selectList 方法执行查询，返回结果
        return forumreplyMapper.selectList(queryWrapper);
    }
}
