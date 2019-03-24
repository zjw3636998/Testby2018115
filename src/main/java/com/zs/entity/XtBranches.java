package com.zs.entity;

import java.util.Date;

public class XtBranches {
    private String bId;

    private Date bDate;

    private Date bMaintainDate;

    private Integer bMaintainWeek;

    private String bNum1;

    private String bName1;

    private String bMaster1;

    private String bNum2;

    private String bName2;

    private String bNote;

    private String bType;

    private Date bCreateTime;

    private String bState;

    private String uNum;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Date getbMaintainDate() {
        return bMaintainDate;
    }

    public void setbMaintainDate(Date bMaintainDate) {
        this.bMaintainDate = bMaintainDate;
    }

    public Integer getbMaintainWeek() {
        return bMaintainWeek;
    }

    public void setbMaintainWeek(Integer bMaintainWeek) {
        this.bMaintainWeek = bMaintainWeek;
    }

    public String getbNum1() {
        return bNum1;
    }

    public void setbNum1(String bNum1) {
        this.bNum1 = bNum1 == null ? null : bNum1.trim();
    }

    public String getbName1() {
        return bName1;
    }

    public void setbName1(String bName1) {
        this.bName1 = bName1 == null ? null : bName1.trim();
    }

    public String getbMaster1() {
        return bMaster1;
    }

    public void setbMaster1(String bMaster1) {
        this.bMaster1 = bMaster1 == null ? null : bMaster1.trim();
    }

    public String getbNum2() {
        return bNum2;
    }

    public void setbNum2(String bNum2) {
        this.bNum2 = bNum2 == null ? null : bNum2.trim();
    }

    public String getbName2() {
        return bName2;
    }

    public void setbName2(String bName2) {
        this.bName2 = bName2 == null ? null : bName2.trim();
    }

    public String getbNote() {
        return bNote;
    }

    public void setbNote(String bNote) {
        this.bNote = bNote == null ? null : bNote.trim();
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType == null ? null : bType.trim();
    }

    public Date getbCreateTime() {
        return bCreateTime;
    }

    public void setbCreateTime(Date bCreateTime) {
        this.bCreateTime = bCreateTime;
    }

    public String getbState() {
        return bState;
    }

    public void setbState(String bState) {
        this.bState = bState == null ? null : bState.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }
}