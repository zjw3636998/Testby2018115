package com.zs.entity;

import java.util.Date;

public class QuotaMan {
    private String qmId;

    private String uNum;

    private Integer qmTypeZc;

    private Integer qmTypeWh;

    private Integer qmTypeZx;

    private Date qmDate;

    private String qmTable;

    public String getQmId() {
        return qmId;
    }

    public void setQmId(String qmId) {
        this.qmId = qmId == null ? null : qmId.trim();
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }

    public Integer getQmTypeZc() {
        return qmTypeZc;
    }

    public void setQmTypeZc(Integer qmTypeZc) {
        this.qmTypeZc = qmTypeZc;
    }

    public Integer getQmTypeWh() {
        return qmTypeWh;
    }

    public void setQmTypeWh(Integer qmTypeWh) {
        this.qmTypeWh = qmTypeWh;
    }

    public Integer getQmTypeZx() {
        return qmTypeZx;
    }

    public void setQmTypeZx(Integer qmTypeZx) {
        this.qmTypeZx = qmTypeZx;
    }

    public Date getQmDate() {
        return qmDate;
    }

    public void setQmDate(Date qmDate) {
        this.qmDate = qmDate;
    }

    public String getQmTable() {
        return qmTable;
    }

    public void setQmTable(String qmTable) {
        this.qmTable = qmTable == null ? null : qmTable.trim();
    }
}