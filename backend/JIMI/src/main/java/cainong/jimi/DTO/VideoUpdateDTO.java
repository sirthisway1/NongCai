package cainong.jimi.DTO;

public class VideoUpdateDTO {

    private String videoID;
    private String videoName;
    private String videoAddress;
    private String videoImage;
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

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Override
    public String toString() {
        return "VideoUpdateDTO{" +
                "videoID='" + videoID + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoAddress='" + videoAddress + '\'' +
                ", videoImage='" + videoImage + '\'' +
                ", videoType='" + videoType + '\'' +
                '}';
    }
}