package com.zs.entity;

public class QuotaCoreData {
    private String dId;

    private String iId;

    private Double d1;

    private Double d2;

    private Double d3;

    private Double d4;

    private Double d5;

    private Double d6;

    private Double d7;

    private Double d8;

    private Double d9;

    private Double d10;

    private Double d11;

    private Double d12;

    private String dNote;

    private String dState;

    private QuotaCoreInfo coreInfo;

    
    public QuotaCoreInfo getCoreInfo() {
		return coreInfo;
	}

	public void setCoreInfo(QuotaCoreInfo coreInfo) {
		this.coreInfo = coreInfo;
	}

	public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId == null ? null : iId.trim();
    }

    public Double getD1() {
        return d1;
    }

    public void setD1(Double d1) {
        this.d1 = d1;
    }

    public Double getD2() {
        return d2;
    }

    public void setD2(Double d2) {
        this.d2 = d2;
    }

    public Double getD3() {
        return d3;
    }

    public void setD3(Double d3) {
        this.d3 = d3;
    }

    public Double getD4() {
        return d4;
    }

    public void setD4(Double d4) {
        this.d4 = d4;
    }

    public Double getD5() {
        return d5;
    }

    public void setD5(Double d5) {
        this.d5 = d5;
    }

    public Double getD6() {
        return d6;
    }

    public void setD6(Double d6) {
        this.d6 = d6;
    }

    public Double getD7() {
        return d7;
    }

    public void setD7(Double d7) {
        this.d7 = d7;
    }

    public Double getD8() {
        return d8;
    }

    public void setD8(Double d8) {
        this.d8 = d8;
    }

    public Double getD9() {
        return d9;
    }

    public void setD9(Double d9) {
        this.d9 = d9;
    }

    public Double getD10() {
        return d10;
    }

    public void setD10(Double d10) {
        this.d10 = d10;
    }

    public Double getD11() {
        return d11;
    }

    public void setD11(Double d11) {
        this.d11 = d11;
    }

    public Double getD12() {
        return d12;
    }

    public void setD12(Double d12) {
        this.d12 = d12;
    }

    public String getdNote() {
        return dNote;
    }

    public void setdNote(String dNote) {
        this.dNote = dNote == null ? null : dNote.trim();
    }

    public String getdState() {
        return dState;
    }

    public void setdState(String dState) {
        this.dState = dState == null ? null : dState.trim();
    }

	@Override
	public String toString() {
		return "QuotaCoreData [dId=" + dId + ", iId=" + iId + ", d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4
				+ ", d5=" + d5 + ", d6=" + d6 + ", d7=" + d7 + ", d8=" + d8 + ", d9=" + d9 + ", d10=" + d10 + ", d11="
				+ d11 + ", d12=" + d12 + ", dNote=" + dNote + ", dState=" + dState + ", coreInfo=" + coreInfo + "]";
	}
    
    
}