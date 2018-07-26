package com.renren.renrenXiao.bean.entity.rdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 印象标签表实体类
 * @author Segoul
 *
 */

public class ImpressionTag {
    
	private Integer id;  //主键ID

    private Integer cardId;  //名片ID

    private String content;  //标签内容

    private Integer initialPoint;  //初始默认点赞数

    private Integer supportPoint;  //用户点赞数

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(Integer initialPoint) {
        this.initialPoint = initialPoint;
    }

    public Integer getSupportPoint() {
        return supportPoint;
    }

    public void setSupportPoint(Integer supportPoint) {
        this.supportPoint = supportPoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}