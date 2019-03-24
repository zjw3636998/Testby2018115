package com.zs.entity;

import java.util.Date;

public class XtBqq {
    private String bId;

    private String bNum;

    private String bName;

    private String bNetNumber;

    private String bNetName;

    private String bMan;

    private String bSection;

    private Date bRegisterDate;

    private String bIt;

    private Date bServiceDate;

    private String bType;

    private String bState;

    private String uNum;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public String getbNum() {
        return bNum;
    }

    public void setbNum(String bNum) {
        this.bNum = bNum == null ? null : bNum.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbNetNumber() {
        return bNetNumber;
    }

    public void setbNetNumber(String bNetNumber) {
        this.bNetNumber = bNetNumber == null ? null : bNetNumber.trim();
    }

    public String getbNetName() {
        return bNetName;
    }

    public void setbNetName(String bNetName) {
        this.bNetName = bNetName == null ? null : bNetName.trim();
    }

    public String getbMan() {
        return bMan;
    }

    public void setbMan(String bMan) {
        this.bMan = bMan == null ? null : bMan.trim();
    }

    public String getbSection() {
        return bSection;
    }

    public void setbSection(String bSection) {
        this.bSection = bSection == null ? null : bSection.trim();
    }

    public Date getbRegisterDate() {
        return bRegisterDate;
    }

    public void setbRegisterDate(Date bRegisterDate) {
        this.bRegisterDate = bRegisterDate;
    }

    public String getbIt() {
        return bIt;
    }

    public void setbIt(String bIt) {
        this.bIt = bIt == null ? null : bIt.trim();
    }

    public Date getbServiceDate() {
        return bServiceDate;
    }

    public void setbServiceDate(Date bServiceDate) {
        this.bServiceDate = bServiceDate;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType == null ? null : bType.trim();
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