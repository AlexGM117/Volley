package com.example.jc.volley.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jc on 15/07/16.
 */
public class User {
    @SerializedName("userId")
    @Expose
    private int userId;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("firstLastName")
    @Expose
    private String firstLastName;

    @SerializedName("secondLastName")
    @Expose
    private String secondLastName;

    @SerializedName("profile")
    @Expose
    private Profile profile;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("restoredPassword")
    @Expose
    private boolean restoredPassword;

    @SerializedName("region")
    @Expose
    private Regions region;

    @SerializedName("department")
    @Expose
    private Departments department;

    @SerializedName("province")
    @Expose
    private Provinces province;

    @SerializedName("district")
    @Expose
    private Districts district;

    @SerializedName("canal")
    @Expose
    private Canal canal;

    @SerializedName("salePoint")
    @Expose
    private Local salePoint;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsename() {
        return username;
    }

    public void setUsename(String usename) {
        this.username = usename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isRestoredPassword() {
        return restoredPassword;
    }

    public void setRestoredPassword(boolean restoredPassword) {
        this.restoredPassword = restoredPassword;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public Provinces getProvince() {
        return province;
    }

    public void setProvince(Provinces province) {
        this.province = province;
    }

    public Districts getDistrict() {
        return district;
    }

    public void setDistrict(Districts district) {
        this.district = district;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public Local getSalePoint() {
        return salePoint;
    }

    public void setSalePoint(Local salePoint) {
        this.salePoint = salePoint;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", usename='" + username + '\'' +
                ", name='" + name + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", profile=" + profile +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", restoredPassword=" + restoredPassword +
                ", region=" + region +
                ", department=" + department +
                ", province=" + province +
                ", district=" + district +
                ", canal=" + canal +
                ", salePoint=" + salePoint +
                '}';
    }
}
