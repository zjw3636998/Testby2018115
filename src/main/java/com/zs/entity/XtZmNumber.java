package com.zs.entity;

import java.util.Date;

public class XtZmNumber {
    private String zmId;

    private Date zmApplyDate;

    private String zmApplyCs;

    private String zmApplyMaster;

    private String zmNumber;

    private String zmOnJob;

    private String zmServiceMaster;

    private Date zmServiceDate;

    private Integer zmServiceWeek;

    private String zmNote;

    private String zmType;

    private Date zmCreateTime;

    private String zmState;

    private String uNum;

    public String getZmId() {
        return zmId;
    }

    public void setZmId(String zmId) {
        this.zmId = zmId == null ? null : zmId.trim();
    }

    public Date getZmApplyDate() {
        return zmApplyDate;
    }

    public void setZmApplyDate(Date zmApplyDate) {
        this.zmApplyDate = zmApplyDate;
    }

    public String getZmApplyCs() {
        return zmApplyCs;
    }

    public void setZmApplyCs(String zmApplyCs) {
        this.zmApplyCs = zmApplyCs == null ? null : zmApplyCs.trim();
    }

    public String getZmApplyMaster() {
        return zmApplyMaster;
    }

    public void setZmApplyMaster(String zmApplyMaster) {
        this.zmApplyMaster = zmApplyMaster == null ? null : zmApplyMaster.trim();
    }

    public String getZmNumber() {
        return zmNumber;
    }

    public void setZmNumber(String zmNumber) {
        this.zmNumber = zmNumber == null ? null : zmNumber.trim();
    }

    public String getZmOnJob() {
        return zmOnJob;
    }

    public void setZmOnJob(String zmOnJob) {
        this.zmOnJob = zmOnJob == null ? null : zmOnJob.trim();
    }

    public String getZmServiceMaster() {
        return zmServiceMaster;
    }

    public void setZmServiceMaster(String zmServiceMaster) {
        this.zmServiceMaster = zmServiceMaster == null ? null : zmServiceMaster.trim();
    }

    public Date getZmServiceDate() {
        return zmServiceDate;
    }

    public void setZmServiceDate(Date zmServiceDate) {
        this.zmServiceDate = zmServiceDate;
    }

    public Integer getZmServiceWeek() {
        return zmServiceWeek;
    }

    public void setZmServiceWeek(Integer zmServiceWeek) {
        this.zmServiceWeek = zmServiceWeek;
    }

    public String getZmNote() {
        return zmNote;
    }

    public void setZmNote(String zmNote) {
        this.zmNote = zmNote == null ? null : zmNote.trim();
    }

    public String getZmType() {
        return zmType;
    }

    public void setZmType(String zmType) {
        this.zmType = zmType == null ? null : zmType.trim();
    }

    public Date getZmCreateTime() {
        return zmCreateTime;
    }

    public void setZmCreateTime(Date zmCreateTime) {
        this.zmCreateTime = zmCreateTime;
    }

    public String getZmState() {
        return zmState;
    }

    public void setZmState(String zmState) {
        this.zmState = zmState == null ? null : zmState.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }
}