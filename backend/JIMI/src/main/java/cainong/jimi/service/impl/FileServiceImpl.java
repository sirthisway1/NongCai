package cainong.jimi.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cainong.jimi.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {


    @Value("${file.upload.path}")
    private String fileUploadDir;


    @Override
    public String uploadFile(MultipartFile file) {
        List<String> filePaths = new ArrayList<>();
        String originalFilename = file.getOriginalFilename();  // 文件完整名称
        String extName = FileUtil.extName(originalFilename);   // 文件后缀名
        String uniFileFlag = IdUtil.fastSimpleUUID();          // 随机生成文件名
        String fileFullName = uniFileFlag + StrUtil.DOT + extName;
        String fileUploadPath = getFileUploadPath(fileFullName);
        try {
            File uploadFile = new File(fileUploadPath);
            File parentFile = uploadFile.getParentFile();
            if (!parentFile.exists()) {
                boolean dirsCreated = parentFile.mkdirs();
                if (!dirsCreated) {
                    return "文件上传失败: 创建目录失败";
                }
            }
            file.transferTo(uploadFile);
            String uploadPath = "/Files/" + fileFullName; // 文件上传后的访问网址
            filePaths.add(uploadPath);
        } catch (IOException e) {
            return "文件上传失败: IO异常";
        } catch (Exception e) {
            return  "文件上传失败: 未知错误";
        }

        return "文件上传成功";
    }

    private String getFileUploadPath(String fileName) {
        try {
            // 获取项目根目录路径
            String uploadDirPath = "D:/NoteFiles/Image/";
            File uploadDir = new File(uploadDirPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            return new File(uploadDir, fileName).getAbsolutePath();
        } catch (Exception e) {
            return "获取上传路径失败";
        }
    }

}