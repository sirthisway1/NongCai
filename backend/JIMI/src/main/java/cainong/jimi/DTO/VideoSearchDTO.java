package cainong.jimi.DTO;

public class VideoSearchDTO {

    private String videoID;
    private String videoName;
    private String videoImage;

    // Getter and Setter methods
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

    @Override
    public String toString() {
        return "VideoSearchDTO{" +
                "videoID='" + videoID + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoImage='" + videoImage + '\'' +
                '}';
    }
}