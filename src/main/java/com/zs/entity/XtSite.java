package com.zs.entity;

import java.util.Date;

public class XtSite {
    private String sId;

    private String sNum;

    private String sName;

    private Date sStartDate;

    private Date sMaintainDate;

    private Integer sMaintainCycle;

    private String sMaintainType;

    private String sMaintainMan;

    private String sNotice;

    private String sNote;

    private String sSiteType;

    private Date sCreateTime;

    private String sState;

    private String uNum;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getsNum() {
        return sNum;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum == null ? null : sNum.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Date getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(Date sStartDate) {
        this.sStartDate = sStartDate;
    }

    public Date getsMaintainDate() {
        return sMaintainDate;
    }

    public void setsMaintainDate(Date sMaintainDate) {
        this.sMaintainDate = sMaintainDate;
    }

    public Integer getsMaintainCycle() {
        return sMaintainCycle;
    }

    public void setsMaintainCycle(Integer sMaintainCycle) {
        this.sMaintainCycle = sMaintainCycle;
    }

    public String getsMaintainType() {
        return sMaintainType;
    }

    public void setsMaintainType(String sMaintainType) {
        this.sMaintainType = sMaintainType == null ? null : sMaintainType.trim();
    }

    public String getsMaintainMan() {
        return sMaintainMan;
    }

    public void setsMaintainMan(String sMaintainMan) {
        this.sMaintainMan = sMaintainMan == null ? null : sMaintainMan.trim();
    }

    public String getsNotice() {
        return sNotice;
    }

    public void setsNotice(String sNotice) {
        this.sNotice = sNotice == null ? null : sNotice.trim();
    }

    public String getsNote() {
        return sNote;
    }

    public void setsNote(String sNote) {
        this.sNote = sNote == null ? null : sNote.trim();
    }

    public String getsSiteType() {
        return sSiteType;
    }

    public void setsSiteType(String sSiteType) {
        this.sSiteType = sSiteType == null ? null : sSiteType.trim();
    }

    public Date getsCreateTime() {
        return sCreateTime;
    }

    public void setsCreateTime(Date sCreateTime) {
        this.sCreateTime = sCreateTime;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState == null ? null : sState.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }
}