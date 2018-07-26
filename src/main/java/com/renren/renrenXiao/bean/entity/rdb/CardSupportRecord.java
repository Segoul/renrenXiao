package com.renren.renrenXiao.bean.entity.rdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 名片点赞记录表实体类
 * @author Segoul
 *
 */

public class CardSupportRecord {
    
	private Integer id;  //主键ID

    private Integer cardId;  //名片ID

    private Integer userId;  //用户ID

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}