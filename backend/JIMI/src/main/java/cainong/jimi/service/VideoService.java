package cainong.jimi.service;

import cainong.jimi.DTO.RecommendVideoDTO;
import cainong.jimi.DTO.UploadVideoDTO;
import cainong.jimi.DTO.VideoUpdateDTO;
import cainong.jimi.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService extends IService<Video> {

    // 获取推荐视频，随机返回 8 个视频
    List<RecommendVideoDTO> getRecommendedVideos();

    // 根据视频ID获取视频详情
    Video getVideoByVideoID(String videoID);

    UploadVideoDTO saveVideo(MultipartFile file, Video video) throws IOException;

    String saveImg(MultipartFile file) throws IOException;

    boolean updateVideo(VideoUpdateDTO videoUpdateDTO);
}