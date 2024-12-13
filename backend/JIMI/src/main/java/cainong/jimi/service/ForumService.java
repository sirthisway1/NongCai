package cainong.jimi.service;

import cainong.jimi.entity.Forum;
import java.util.List;

public interface ForumService {
    // 获取所有帖子
    List<Forum> getAllForums();

    // 根据 forumID 获取指定帖子
    Forum getForumById(String forumID);
}