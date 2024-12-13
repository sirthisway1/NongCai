package cainong.jimi.entity;

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
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("forumID")
    private String forumID;

    private String forumTitle;

    private String forumContent;

    private String forumUsername;

    private String forumTime;

    private String forumType;

    private String forumAmount;

    private String forumImg;

    public String getForumID() {
        return forumID;
    }

    public void setForumID(String forumID) {
        this.forumID = forumID;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getForumUsername() {
        return forumUsername;
    }

    public void setForumUserforumname(String forumUsername) {
        this.forumUsername = forumUsername;
    }

    public String getForumTime() {
        return forumTime;
    }

    public void setForumTime(String forumTime) {
        this.forumTime = forumTime;
    }

    public String getForumType() {
        return forumType;
    }

    public void setForumType(String forumType) {
        this.forumType = forumType;
    }

    public String getForumAmount() {
        return forumAmount;
    }

    public void setForumAmount(String forumAmount) {
        this.forumAmount = forumAmount;
    }

    public String getForumImg() {
        return forumImg;
    }

    public void setForumImg(String forumImg) {
        this.forumImg = forumImg;
    }

    @Override
    public String toString() {
        return "Forum{" +
            "forumID = " + forumID +
            ", forumTitle = " + forumTitle +
            ", forumContent = " + forumContent +
            ", forumUsername = " + forumUsername +
            ", forumTime = " + forumTime +
            ", forumType = " + forumType +
            ", forumAmount = " + forumAmount +
            ", forumImg = " + forumImg +
        "}";
    }
}
