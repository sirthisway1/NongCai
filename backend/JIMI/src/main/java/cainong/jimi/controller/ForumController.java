package cainong.jimi.controller;

import cainong.jimi.entity.Forum;
import cainong.jimi.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForumController {

    @Autowired
    private ForumService forumService;

    // 获取所有帖子
    @GetMapping("/forums")
    public List<Forum> getAllForums() {
        return forumService.getAllForums();
    }

    // 根据 forumID 获取指定帖子
    @GetMapping("/forum/{forumID}")
    public Forum getForum(@PathVariable String forumID) {
        return forumService.getForumById(forumID);
    }
}
