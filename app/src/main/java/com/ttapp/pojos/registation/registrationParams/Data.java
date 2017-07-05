package com.ttapp.pojos.registation.registrationParams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("districtName")
    @Expose
    private String districtName;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("firmName")
    @Expose
    private String firmName;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mondalName")
    @Expose
    private String mondalName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phonrNumber")
    @Expose
    private Integer phonrNumber;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userType")
    @Expose
    private String userType;
    @SerializedName("villageName")
    @Expose
    private String villageName;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMondalName() {
        return mondalName;
    }

    public void setMondalName(String mondalName) {
        this.mondalName = mondalName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhonrNumber() {
        return phonrNumber;
    }

    public void setPhonrNumber(Integer phonrNumber) {
        this.phonrNumber = phonrNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

}
