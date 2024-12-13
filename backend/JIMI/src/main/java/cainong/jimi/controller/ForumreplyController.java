package cainong.jimi.controller;

import cainong.jimi.entity.Forumreply;
import cainong.jimi.service.ForumreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForumreplyController {

    @Autowired
    private ForumreplyService forumreplyService;

    // 发表评论
    @PostMapping("/reply")
    public String postReply(@RequestBody Forumreply forumreply) {
        boolean success = forumreplyService.postReply(forumreply);
        return success ? "评论发布成功" : "评论发布失败";
    }

    // 获取指定帖子的所有评论
    @GetMapping("/replies/{forumID}")
    public List<Forumreply> getRepliesByForumID(@PathVariable String forumID) {
        return forumreplyService.getRepliesByForumID(forumID);
    }
}
