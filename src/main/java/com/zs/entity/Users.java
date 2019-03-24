package com.zs.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Users {
	
    private String uNum;

    private String uPass;

    private String uName;

    private String csId;

    private String uJob;

    private Date uStartTime;

    private String rId;

    private String uMail;

    private String uState;

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum == null ? null : uNum.trim();
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass == null ? null : uPass.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId == null ? null : csId.trim();
    }

    public String getuJob() {
        return uJob;
    }

    public void setuJob(String uJob) {
        this.uJob = uJob == null ? null : uJob.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getuStartTime() {
        return uStartTime;
    }

    public void setuStartTime(Date uStartTime) {
        this.uStartTime = uStartTime;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail == null ? null : uMail.trim();
    }

    public String getuState() {
        return uState;
    }

    public void setuState(String uState) {
        this.uState = uState == null ? null : uState.trim();
    }

	public Users(String uNum, String uPass, String uName, String csId, String uJob, Date uStartTime, String rId,
			String uMail, String uState) {
		super();
		this.uNum = uNum;
		this.uPass = uPass;
		this.uName = uName;
		this.csId = csId;
		this.uJob = uJob;
		this.uStartTime = uStartTime;
		this.rId = rId;
		this.uMail = uMail;
		this.uState = uState;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [uNum=" + uNum + ", uPass=" + uPass + ", uName=" + uName + ", csId=" + csId + ", uJob=" + uJob
				+ ", uStartTime=" + uStartTime + ", rId=" + rId + ", uMail=" + uMail + ", uState=" + uState + "]";
	}
    
    
}