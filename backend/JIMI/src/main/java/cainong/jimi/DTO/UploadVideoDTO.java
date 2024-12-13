package cainong.jimi.DTO;

public class UploadVideoDTO {

    private String videoID;

    private String videoAddress;


    // Getters and Setters
    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoName) {
        this.videoAddress = videoName;
    }


    @Override
    public String toString() {
        return "RecommendVideoDTO{" +
                "videoID='" + videoID + '\'' +
                ", videoName='" + videoAddress + '\'' +
                '}';
    }
}