package cainong.jimi.service;

import cainong.jimi.DTO.ForumReplyDTO;
import cainong.jimi.entity.Forumreply;
import java.util.List;

public interface ForumreplyService {
    // 获取指定帖子的所有评论
    List<Forumreply> getRepliesByForumID(String forumID);

    boolean addReply(ForumReplyDTO forumReplyDTO);
}