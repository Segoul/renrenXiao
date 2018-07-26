package com.renren.renrenXiao.bean.entity.rdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 顾客浏览商城记录表实体类
 * @author Segoul
 *
 */

public class AccessMallRecord {
    
	private Integer id;  //主键ID

    private Integer userId;  //用户从表ID

    private Integer cardId;  //名片ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;  //创建时间（访问时间）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}