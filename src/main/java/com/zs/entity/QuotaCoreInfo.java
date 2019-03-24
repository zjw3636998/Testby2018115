package com.zs.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QuotaCoreInfo {
    private String iId;

    private String iType;

    private String iName;

    private String iMaster;

    private String iDefinition;

    private String iUnit;

    private String iSource;

    private String iFormula;

    private Double iTargetValue;

    private Date iYear;

    private String iState;

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId == null ? null : iId.trim();
    }

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType == null ? null : iType.trim();
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public String getiMaster() {
        return iMaster;
    }

    public void setiMaster(String iMaster) {
        this.iMaster = iMaster == null ? null : iMaster.trim();
    }

    public String getiDefinition() {
        return iDefinition;
    }

    public void setiDefinition(String iDefinition) {
        this.iDefinition = iDefinition == null ? null : iDefinition.trim();
    }

    public String getiUnit() {
        return iUnit;
    }

    public void setiUnit(String iUnit) {
        this.iUnit = iUnit == null ? null : iUnit.trim();
    }

    public String getiSource() {
        return iSource;
    }

    public void setiSource(String iSource) {
        this.iSource = iSource == null ? null : iSource.trim();
    }

    public String getiFormula() {
        return iFormula;
    }

    public void setiFormula(String iFormula) {
        this.iFormula = iFormula == null ? null : iFormula.trim();
    }

    public Double getiTargetValue() {
        return iTargetValue;
    }

    public void setiTargetValue(Double iTargetValue) {
        this.iTargetValue = iTargetValue;
    }

    @JsonFormat(pattern="yyyy",timezone = "GMT+8")
    public Date getiYear() {
        return iYear;
    }

    public void setiYear(Date iYear) {
        this.iYear = iYear;
    }

    public String getiState() {
        return iState;
    }

    public void setiState(String iState) {
        this.iState = iState == null ? null : iState.trim();
    }
}