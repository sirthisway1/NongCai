package cainong.jimi.controller;

import cainong.jimi.DTO.ForumDTO;
import cainong.jimi.entity.Forum;
import cainong.jimi.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    // 获取所有帖子
    @GetMapping("/forums")
    public List<Forum> getAllForums() {
        return forumService.getAllForums();
    }

    // 根据 forumID 获取指定帖子
    @GetMapping("/{forumID}")
    public Forum getForum(@PathVariable String forumID) {
        return forumService.getForumById(forumID);
    }

    @PostMapping("/create")
    public boolean createForum(@RequestBody ForumDTO forumDTO) {
        return forumService.createForum(forumDTO.getForumTitle(), forumDTO.getForumContent(), forumDTO.getForumType(), forumDTO.getForumUsername());
    }


}
