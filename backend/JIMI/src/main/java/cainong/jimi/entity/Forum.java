package cainong.jimi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 论坛实体类
 * </p>
 *
 * @author xmg
 * @since 2024-12-03
 */
@TableName("forum")
@Data
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "forumID", type = IdType.ASSIGN_UUID)
    private String forumID;

    @TableField("forumTitle")
    private String forumTitle;

    @TableField("forumContent")
    private String forumContent;

    @TableField("forumUsername")
    private String forumUsername;

    @TableField("forumTime")
    private String forumTime;

    @TableField("forumType")
    private String forumType;

    @TableField("forumAmount")
    private String forumAmount;

    @TableField("forumImg")
    private String forumImg;
}