package cainong.jimi.service.impl;

import cainong.jimi.DTO.RecommendVideoDTO;
import cainong.jimi.DTO.UploadVideoDTO;
import cainong.jimi.entity.Video;
import cainong.jimi.mapper.VideoMapper;
import cainong.jimi.service.VideoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Value("${video.upload-video-dir}")
    private String uploadVideoDir;

    @Value("${video.upload-image-dir}")
    private String uploadImageDir;

    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String downloadIp;


    @Autowired
    public VideoServiceImpl(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }


    @Override
    public List<RecommendVideoDTO> getRecommendedVideos() {
        // 随机选择 8 个视频
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(new Random().nextBoolean(), "RAND()").last("LIMIT 8");
        List<Video> recommendedVideos = videoMapper.selectList(queryWrapper);

        // 将 Video 实体转换为 RecommendVideoDTO
        return recommendedVideos.stream()
                .map(video -> {
                    RecommendVideoDTO dto = new RecommendVideoDTO();
                    dto.setVideoID(video.getVideoID());
                    dto.setVideoName(video.getVideoName());
                    dto.setVideoImage(video.getVideoImage());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public UploadVideoDTO saveVideo(MultipartFile file, Video video) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        // 创建上传目录（如果不存在）
        Path uploadPath = Paths.get(uploadVideoDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 生成唯一文件名
        String fileFullName = generateUniqueFileName(file.getOriginalFilename());
        video.setVideoID(fileFullName);

        // 创建文件并保存
        File videoFile = new File(uploadVideoDir + fileFullName);
        file.transferTo(videoFile);

        // 设置视频地址（HTTP形式）
        String uploadPathHttp = "http://" + downloadIp + ":" + port + "/videos/" + fileFullName;
        video.setVideoAddress(uploadPathHttp);

        // 保存视频信息到数据库
        videoMapper.insert(video);

        // 创建并返回 UploadVideoDTO 对象
        UploadVideoDTO uploadVideoDTO = new UploadVideoDTO();
        uploadVideoDTO.setVideoID(video.getVideoID());
        uploadVideoDTO.setVideoAddress(video.getVideoAddress());

        return uploadVideoDTO;
    }

    @Override
    public String saveImg(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        // 创建上传目录（如果不存在）
        Path uploadPath = Paths.get(uploadImageDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 生成唯一文件名
        String fileFullName = generateUniqueFileName(file.getOriginalFilename());

        // 创建文件并保存
        File imageFile = new File(uploadImageDir + fileFullName);
        file.transferTo(imageFile);

        // 设置视频地址（HTTP形式）
        String uploadPathHttp = "http://" + downloadIp + ":" + port + "/images/" + fileFullName;

        return uploadPathHttp;
    }

    @Override
    public Video getVideoByVideoID(String videoID) {
        return videoMapper.selectById(videoID);
    }

    // 获取文件扩展名
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private String generateUniqueFileName(String originalFilename) {
        // 生成 UUID 并去掉分隔符
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 获取文件扩展名
        String fileExtension = getFileExtension(originalFilename);
        // 截取 UUID 的部分字符串以确保总长度不超过32个字符
        String uniquePart = uuid.substring(0, Math.min(uuid.length(), 32 - fileExtension.length()));
        return uniquePart + fileExtension;
    }
}