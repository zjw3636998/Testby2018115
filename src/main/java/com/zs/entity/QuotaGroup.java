package com.zs.entity;

import java.util.Date;

public class QuotaGroup {
    private String qgId;

    private Date qgDate;

    private String qgGroup;

    private String qgFunctionary;

    private Integer qgTypeZc;

    private Integer qgTypeWh;

    private Integer qgTypeZx;

    private Integer qgCount;

    private Double qgProductivity;

    public String getQgId() {
        return qgId;
    }

    public void setQgId(String qgId) {
        this.qgId = qgId == null ? null : qgId.trim();
    }

    public Date getQgDate() {
        return qgDate;
    }

    public void setQgDate(Date qgDate) {
        this.qgDate = qgDate;
    }

    public String getQgGroup() {
        return qgGroup;
    }

    public void setQgGroup(String qgGroup) {
        this.qgGroup = qgGroup == null ? null : qgGroup.trim();
    }

    public String getQgFunctionary() {
        return qgFunctionary;
    }

    public void setQgFunctionary(String qgFunctionary) {
        this.qgFunctionary = qgFunctionary == null ? null : qgFunctionary.trim();
    }

    public Integer getQgTypeZc() {
        return qgTypeZc;
    }

    public void setQgTypeZc(Integer qgTypeZc) {
        this.qgTypeZc = qgTypeZc;
    }

    public Integer getQgTypeWh() {
        return qgTypeWh;
    }

    public void setQgTypeWh(Integer qgTypeWh) {
        this.qgTypeWh = qgTypeWh;
    }

    public Integer getQgTypeZx() {
        return qgTypeZx;
    }

    public void setQgTypeZx(Integer qgTypeZx) {
        this.qgTypeZx = qgTypeZx;
    }

    public Integer getQgCount() {
        return qgCount;
    }

    public void setQgCount(Integer qgCount) {
        this.qgCount = qgCount;
    }

    public Double getQgProductivity() {
        return qgProductivity;
    }

    public void setQgProductivity(Double qgProductivity) {
        this.qgProductivity = qgProductivity;
    }
}