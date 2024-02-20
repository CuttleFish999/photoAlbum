package com.photoalbum.dodo.model;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photoid")
    private Integer photoid;                //照片編號

    @Column(name = "memberid")
    private Integer memberid;               //會員編號
    @Column(name = "title")
    private String title;                  //標題
    @Column(name = "description")
    private String description;            //描述
    @Column(name = "filepath")
    private byte[] filepath;               //檔案路徑
    @Column(name = "thumbnailpath")
    private byte[] thumbnailpath;          //縮圖路徑
    @Column(name = "uploadedat")
    private Timestamp uploadedat;          //上傳時間
    @Column(name = "updatedat")
    private Timestamp updatedat;           //更新時間

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFilepath() {
        return filepath;
    }

    public void setFilepath(byte[] filepath) {
        this.filepath = filepath;
    }

    public Timestamp getUploadedat() {
        return uploadedat;
    }

    public void setUploadedat(Timestamp uploadedat) {
        this.uploadedat = uploadedat;
    }

    public Timestamp getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Timestamp updatedat) {
        this.updatedat = updatedat;
    }

    public byte[] getThumbnailpath() {
        return thumbnailpath;
    }

    public void setThumbnailpath(byte[] thumbnailpath) {
        this.thumbnailpath = thumbnailpath;
    }
}
