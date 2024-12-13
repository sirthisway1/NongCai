package cainong.jimi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xmg
 * @since 2024-12-03
 */
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("videoID")
    private String videoID;

    @TableField("videoName")
    private String videoName;

    @TableField("videoImage")
    private String videoImage;

    @TableField("videoAddress")
    private String videoAddress;

    @TableField("videoDuration")
    private String videoDuration;

    @TableField("videoCollection")
    private String videoCollection;

    @TableField("videoComment")
    private String videoComment;

    @TableField("videoUploadTime")
    private String videoUploadTime;

    @TableField("videoState")
    private String videoState;

    @TableField("videoType")
    private String videoType;

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(String videoCollection) {
        this.videoCollection = videoCollection;
    }

    public String getVideoComment() {
        return videoComment;
    }

    public void setVideoComment(String videoComment) {
        this.videoComment = videoComment;
    }

    public String getVideoUploadTime() {
        return videoUploadTime;
    }

    public void setVideoUploadTime(String videoUploadTime) {
        this.videoUploadTime = videoUploadTime;
    }

    public String getVideoState() {
        return videoState;
    }

    public void setVideoState(String videoState) {
        this.videoState = videoState;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Override
    public String toString() {
        return "Video{" +
            "videoID = " + videoID +
            ", videoName = " + videoName +
            ", videoImage = " + videoImage +
            ", videoAddress = " + videoAddress +
            ", videoDuration = " + videoDuration +
            ", videoCollection = " + videoCollection +
            ", videoComment = " + videoComment +
            ", videoUploadTime = " + videoUploadTime +
            ", videoState = " + videoState +
            ", videoType = " + videoType +
        "}";
    }
}
