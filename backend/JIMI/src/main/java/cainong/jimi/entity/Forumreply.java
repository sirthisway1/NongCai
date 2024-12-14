package cainong.jimi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Forumreply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "replyID", type = IdType.ASSIGN_UUID)
    private String replyID;

    @TableField("replyContent")
    private String replyContent;

    @TableField("replyTime")
    private String replyTime;

    @TableField("replyImg")
    private String replyImg;

    @TableField("replyForumID")
    private String replyForumID;

    @TableField("replyName")
    private String replyName;

    public String getReplyID() {
        return replyID;
    }

    public void setReplyID(String replyID) {
        this.replyID = replyID;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyImg() {
        return replyImg;
    }

    public void setReplyImg(String replyImg) {
        this.replyImg = replyImg;
    }

    public String getReplyForumID() {
        return replyForumID;
    }

    public void setReplyForumID(String replyForumID) {
        this.replyForumID = replyForumID;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    @Override
    public String toString() {
        return "Forumreply{" +
            "replyID = " + replyID +
            ", replyContent = " + replyContent +
            ", replyTime = " + replyTime +
            ", replyImg = " + replyImg +
            ", replyForumID = " + replyForumID +
            ", replyName = " + replyName +
        "}";
    }
}
