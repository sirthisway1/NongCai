package cainong.jimi.controller;

import cainong.jimi.DTO.ForumReplyDTO;
import cainong.jimi.entity.Forumreply;
import cainong.jimi.service.ForumreplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forumReply")
public class ForumreplyController {

    @Autowired
    private ForumreplyService forumreplyService;

    @PostMapping("/add")
    public String addForumReply(@RequestBody ForumReplyDTO forumReplyDTO) {
        boolean result = forumreplyService.addReply(forumReplyDTO);
        return result ? "Reply added successfully!" : "Failed to add reply.";
    }

    // 获取指定帖子的所有评论
    @GetMapping("/replies/{forumID}")
    public List<Forumreply> getRepliesByForumID(@PathVariable String forumID) {
        return forumreplyService.getRepliesByForumID(forumID);
    }
}
