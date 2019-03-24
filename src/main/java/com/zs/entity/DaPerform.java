package com.zs.entity;

import java.util.Date;

public class DaPerform {
    private String pId;

    private String uNum;

    private Date pTime;

    private String pState;

    private String uNumNext;

    private String dId;

    private String pNote;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState == null ? null : pState.trim();
    }

    public String getuNumNext() {
        return uNumNext;
    }

    public void setuNumNext(String uNumNext) {
        this.uNumNext = uNumNext == null ? null : uNumNext.trim();
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public String getpNote() {
        return pNote;
    }

    public void setpNote(String pNote) {
        this.pNote = pNote == null ? null : pNote.trim();
    }
}