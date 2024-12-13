package cainong.jimi.service;

import cainong.jimi.entity.Forumreply;
import java.util.List;

public interface ForumreplyService {
    // 发布评论
    boolean postReply(Forumreply forumreply);

    // 获取指定帖子的所有评论
    List<Forumreply> getRepliesByForumID(String forumID);
}