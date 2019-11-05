package com.java.spring.look.web.bean;


public class StudentSign {
    private String id;

    private String userId;

    private String signTime;

    private String signAddress;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignAddress() {
        return signAddress;
    }

    public void setSignAddress(String signAddress) {
        this.signAddress = signAddress == null ? null : signAddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}