package cainong.jimi.service.impl;

import cainong.jimi.DTO.ForumReplyDTO;
import cainong.jimi.entity.Forumreply;
import cainong.jimi.mapper.ForumreplyMapper;
import cainong.jimi.service.ForumreplyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumreplyServiceImpl extends ServiceImpl<ForumreplyMapper, Forumreply> implements ForumreplyService {


    @Override
    public List<Forumreply> getRepliesByForumID(String forumID) {
        // 使用 QueryWrapper 进行条件查询
        QueryWrapper<Forumreply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("replyForumID", forumID);  // 条件：replyForumID = forumID

        // 返回结果，调用 MyBatis-Plus 提供的 list 方法
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addReply(ForumReplyDTO forumReplyDTO) {
        // 创建 Forumreply 实体对象
        Forumreply forumreply = new Forumreply();
        forumreply.setReplyID(generateReplyID());  // 生成唯一回复ID
        forumreply.setReplyForumID(forumReplyDTO.getReplyForumID());
        forumreply.setReplyImg(forumReplyDTO.getReplyImg());
        forumreply.setReplyContent(forumReplyDTO.getReplyContent());
        forumreply.setReplyName(forumReplyDTO.getReplyName());
        forumreply.setReplyTime(getCurrentTime());  // 获取当前时间

        // 调用 MyBatis-Plus 的 save 方法插入数据
        return this.save(forumreply);
    }

    // 生成唯一的回复ID
    private String generateReplyID() {
        return java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 32);
    }

    // 获取当前时间
    private String getCurrentTime() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return java.time.LocalDateTime.now().format(formatter);
    }
}