package com.renren.renrenXiao.bean.entity.rdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 印象标签点赞记录表实体类
 * @author Segoul
 *
 */

public class TagSupportRecord {
    
	private Integer id;  //主键ID

    private Integer tagId;  //印象标签ID

    private Integer userId;  //用户ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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