package com.photoalbum.dodo.model;

import java.sql.Timestamp;
import java.util.Date;

public class Members {

private Integer memberid;                //會員編號
private String account;                  //帳號
private String password;                 //密碼
private String name;                     //姓名
private String email;                    //電子郵件
private Date birthday;                   //生日
private String phonenumber;              //手機號碼
private String otherphonenumber;         //其他手機號碼
private String homenumber;               //家裡電話
private Integer gender;                  //性別
private byte[] avatar;                   //頭像
private Timestamp createtime;            //建立時間
private Timestamp updatedtime;           //更新時間
private Timestamp lastonlinetime;        //最後上線時間


    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOtherphonenumber() {
        return otherphonenumber;
    }

    public void setOtherphonenumber(String otherphonenumber) {
        this.otherphonenumber = otherphonenumber;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Timestamp updatedtime) {
        this.updatedtime = updatedtime;
    }

    public Timestamp getLastonlinetime() {
        return lastonlinetime;
    }

    public void setLastonlinetime(Timestamp lastonlinetime) {
        this.lastonlinetime = lastonlinetime;
    }
}
