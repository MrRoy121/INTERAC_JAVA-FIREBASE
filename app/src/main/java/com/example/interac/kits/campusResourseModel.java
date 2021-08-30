package com.example.interac.kits;

public class campusResourseModel {
    String title, details, image, com, con, tfs, time;

    public String getTitle() {
        return title;
    }

    public campusResourseModel(String title, String details, String image) {
        this.title = title;
        this.details = details;
        this.image = image;
    }

    public campusResourseModel(String title, String details, String image, String time) {
        this.title = title;
        this.details = details;
        this.image = image;
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getTfs() {
        return tfs;
    }

    public void setTfs(String tfs) {
        this.tfs = tfs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public campusResourseModel(String title, String details, String image, String com, String con, String tfs, String time) {
        this.title = title;
        this.details = details;
        this.image = image;
        this.com = com;
        this.con = con;
        this.tfs = tfs;
        this.time = time;
    }
}
