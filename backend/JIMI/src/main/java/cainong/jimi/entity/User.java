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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="userID", type = IdType.ASSIGN_UUID)
    private String userID;

    @TableField("username")
    private String username;

    @TableField("userGender")
    private String userGender;

    @TableField("password")
    private String password;

    @TableField("userImg")
    private String userImg;

    @TableField("userAddress")
    private String userAddress;

    @TableField("userPhone")
    private String userPhone;

    @TableField("userQQ")
    private String userQQ;

    @TableField("userEmail")
    private String userEmail;

    @TableField("userCollection")
    private String userCollection;

    @TableField("userState")
    private String userState;

    @TableField("userLoginTime")
    private String userLoginTime;

    @TableField("userIP")
    private String userIP;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(String userCollection) {
        this.userCollection = userCollection;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(String userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    @Override
    public String toString() {
        return "User{" +
            "userID = " + userID +
            ", username = " + username +
            ", userGender = " + userGender +
            ", password = " + password +
            ", userImg = " + userImg +
            ", userAddress = " + userAddress +
            ", userPhone = " + userPhone +
            ", userQQ = " + userQQ +
            ", userEmail = " + userEmail +
            ", userCollection = " + userCollection +
            ", userState = " + userState +
            ", userLoginTime = " + userLoginTime +
            ", userIP = " + userIP +
        "}";
    }
}
