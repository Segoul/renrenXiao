package com.renren.renrenXiao.bean.entity.rdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户主表实体类
 * @author Segoul
 *
 */

public class MasterUser {
    
	private Integer id;  //主键ID

    private String mobile;  //手机号

    private String identityCard;  //身份证

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}