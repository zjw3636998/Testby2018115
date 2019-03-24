package com.zs.entity;

import java.util.Date;

public class DaDemand {
    private String dId;

    private String dApplicant;

    private String dContent;

    private String dType;

    private Date dTime;

    private Date dTimeExpect;

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public String getdApplicant() {
        return dApplicant;
    }

    public void setdApplicant(String dApplicant) {
        this.dApplicant = dApplicant == null ? null : dApplicant.trim();
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent == null ? null : dContent.trim();
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType == null ? null : dType.trim();
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }

    public Date getdTimeExpect() {
        return dTimeExpect;
    }

    public void setdTimeExpect(Date dTimeExpect) {
        this.dTimeExpect = dTimeExpect;
    }
}