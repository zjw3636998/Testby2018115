package com.zs.entity;

import java.util.Date;

public class XtPdaChange {
    private String cId;

    private Date cDate;

    private Integer cWeek;

    private String cMan;

    private String cPage;

    private String cOldNum;

    private String cNewNum;

    private String cSn;

    private String cIt;

    private Date cChangeDate;

    private String cResult;

    private String cReceiveMan;

    private String cNote;

    private Date cCreateTime;

    private String cType;

    private String cState;

    private String uNum;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Integer getcWeek() {
        return cWeek;
    }

    public void setcWeek(Integer cWeek) {
        this.cWeek = cWeek;
    }

    public String getcMan() {
        return cMan;
    }

    public void setcMan(String cMan) {
        this.cMan = cMan == null ? null : cMan.trim();
    }

    public String getcPage() {
        return cPage;
    }

    public void setcPage(String cPage) {
        this.cPage = cPage == null ? null : cPage.trim();
    }

    public String getcOldNum() {
        return cOldNum;
    }

    public void setcOldNum(String cOldNum) {
        this.cOldNum = cOldNum == null ? null : cOldNum.trim();
    }

    public String getcNewNum() {
        return cNewNum;
    }

    public void setcNewNum(String cNewNum) {
        this.cNewNum = cNewNum == null ? null : cNewNum.trim();
    }

    public String getcSn() {
        return cSn;
    }

    public void setcSn(String cSn) {
        this.cSn = cSn == null ? null : cSn.trim();
    }

    public String getcIt() {
        return cIt;
    }

    public void setcIt(String cIt) {
        this.cIt = cIt == null ? null : cIt.trim();
    }

    public Date getcChangeDate() {
        return cChangeDate;
    }

    public void setcChangeDate(Date cChangeDate) {
        this.cChangeDate = cChangeDate;
    }

    public String getcResult() {
        return cResult;
    }

    public void setcResult(String cResult) {
        this.cResult = cResult == null ? null : cResult.trim();
    }

    public String getcReceiveMan() {
        return cReceiveMan;
    }

    public void setcReceiveMan(String cReceiveMan) {
        this.cReceiveMan = cReceiveMan == null ? null : cReceiveMan.trim();
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote == null ? null : cNote.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }
}