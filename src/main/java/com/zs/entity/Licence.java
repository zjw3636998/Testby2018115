package com.zs.entity;

import java.util.Date;

public class Licence {
    private String lId;

    private String uNum;

    private Date lStart;

    private Date lEnd;

    private String lIp;

    private String lMac;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }

    public Date getlStart() {
        return lStart;
    }

    public void setlStart(Date lStart) {
        this.lStart = lStart;
    }

    public Date getlEnd() {
        return lEnd;
    }

    public void setlEnd(Date lEnd) {
        this.lEnd = lEnd;
    }

    public String getlIp() {
        return lIp;
    }

    public void setlIp(String lIp) {
        this.lIp = lIp == null ? null : lIp.trim();
    }

    public String getlMac() {
        return lMac;
    }

    public void setlMac(String lMac) {
        this.lMac = lMac == null ? null : lMac.trim();
    }
}