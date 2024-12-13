package cainong.jimi.controller;

import cainong.jimi.DTO.RecommendVideoDTO;
import cainong.jimi.DTO.UploadVideoDTO;
import cainong.jimi.entity.Video;
import cainong.jimi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // 获取推荐视频（随机选取 8 个视频）
    @GetMapping("/recommend")
    public List<RecommendVideoDTO> getRecommendedVideos() {
        return videoService.getRecommendedVideos();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadVideo(@RequestParam("video") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("文件不能为空");
        }

        Video video = new Video();
        video.setVideoName(file.getOriginalFilename());
        // 其他视频信息可以在这里设置，例如视频时长、封面等

        try {
            UploadVideoDTO videoDTO = videoService.saveVideo(file, video);
            return ResponseEntity.ok(videoDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("上传过程中出现错误");
        }
    }

    @GetMapping("/play/{videoName}")
    public ResponseEntity<Resource> playVideo(@PathVariable String videoName) {
        Video video = videoService.getVideoByVideoID(videoName);
        if (video != null) {
            Resource videoResource = new FileSystemResource(video.getVideoAddress());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + video.getVideoName() + "\"")
                    .body(videoResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}