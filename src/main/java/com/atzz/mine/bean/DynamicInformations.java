package com.atzz.mine.bean;

import java.util.Date;

public class DynamicInformations {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private Long like;

    private Long unLike;

    private Long numberFloor;

    private String url;

    private String type;

    private Byte isReal;

    private Long adminId;

    private Byte report;

    private String comment;

    private String cover;

    private Long userRegisterId;

    private UserRegisters userRegisters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getUnLike() {
        return unLike;
    }

    public void setUnLike(Long unLike) {
        this.unLike = unLike;
    }

    public Long getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Long numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getIsReal() {
        return isReal;
    }

    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Byte getReport() {
        return report;
    }

    public void setReport(Byte report) {
        this.report = report;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Long getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(Long userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public UserRegisters getUserRegisters() {
        return userRegisters;
    }

    public void setUserRegisters(UserRegisters userRegisters) {
        this.userRegisters = userRegisters;
    }

    public DynamicInformations() {
    }

    public DynamicInformations(Long id, Date createTime, Date updateTime, Date deletedAt, Long like, Long unLike, Long numberFloor, String url, String type, Byte isReal, Long adminId, Byte report, String comment, String cover, Long userRegisterId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.like = like;
        this.unLike = unLike;
        this.numberFloor = numberFloor;
        this.url = url;
        this.type = type;
        this.isReal = isReal;
        this.adminId = adminId;
        this.report = report;
        this.comment = comment;
        this.cover = cover;
        this.userRegisterId = userRegisterId;
    }
}