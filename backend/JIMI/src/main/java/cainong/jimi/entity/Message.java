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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("messageID")
    private String messageID;

    private String messageVideoID;

    private String messageUserID;

    private String messageUserName;

    private String messageContent;

    private String messageTime;

    private String messageImg;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageVideoID() {
        return messageVideoID;
    }

    public void setMessageVideoID(String messageVideoID) {
        this.messageVideoID = messageVideoID;
    }

    public String getMessageUserID() {
        return messageUserID;
    }

    public void setMessageUserID(String messageUserID) {
        this.messageUserID = messageUserID;
    }

    public String getMessageUserName() {
        return messageUserName;
    }

    public void setMessageUserName(String messageUserName) {
        this.messageUserName = messageUserName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
    }

    @Override
    public String toString() {
        return "Message{" +
            "messageID = " + messageID +
            ", messageVideoID = " + messageVideoID +
            ", messageUserID = " + messageUserID +
            ", messageUserName = " + messageUserName +
            ", messageContent = " + messageContent +
            ", messageTime = " + messageTime +
            ", messageImg = " + messageImg +
        "}";
    }
}
