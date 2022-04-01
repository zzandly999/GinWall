package com.atzz.mine.bean;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserRegisters {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private String mobile;

    private String nickName;

    private String avatar;

    private String studentNumber;

    private String email;

    private String password;

    private Byte sex;

    private String constellation;

    private String role;

    private String authenticationToken;

    private String emailAuthentication;

    private String binningTime;

    private Byte isReal;

    private Long adminId;

    private DynamicInformations dynamicInformations;

    public DynamicInformations getDynamicInformations() {
        return dynamicInformations;
    }

    public void setDynamicInformations(DynamicInformations dynamicInformations) {
        this.dynamicInformations = dynamicInformations;
    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken == null ? null : authenticationToken.trim();
    }

    public String getEmailAuthentication() {
        return emailAuthentication;
    }

    public void setEmailAuthentication(String emailAuthentication) {
        this.emailAuthentication = emailAuthentication == null ? null : emailAuthentication.trim();
    }

    public String getBinningTime() {
        return binningTime;
    }

    public void setBinningTime(String binningTime) {
        this.binningTime = binningTime == null ? null : binningTime.trim();
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

    public UserRegisters() {
    }

    public UserRegisters(Long id, Date createTime, Date updateTime, Date deletedAt, String mobile, String nickName, String avatar, String studentNumber, String email, String password, Byte sex, String constellation, String role, String authenticationToken, String emailAuthentication, String binningTime, Byte isReal, Long adminId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.mobile = mobile;
        this.nickName = nickName;
        this.avatar = avatar;
        this.studentNumber = studentNumber;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.constellation = constellation;
        this.role = role;
        this.authenticationToken = authenticationToken;
        this.emailAuthentication = emailAuthentication;
        this.binningTime = binningTime;
        this.isReal = isReal;
        this.adminId = adminId;
    }
}