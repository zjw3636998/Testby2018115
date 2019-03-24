package com.jzzx.bean;
	/**
	 * 上传文件类
	 * */
public class FileTable {
	
	private int file_id;//文件ID
	private String file_name;//文件名称
	private int file_type;//文件类型
	private String file_url;//文件本地路径
	private String file_user;//上传人
	private String file_createtime;//上传时间
	private String file_reporttime;//备注信息
	public FileTable() {
		super();
	}
	
	
	public FileTable(String file_name, int file_type, String file_url, String file_user, String file_createtime) {
		super();
		this.file_name = file_name;
		this.file_type = file_type;
		this.file_url = file_url;
		this.file_user = file_user;
		this.file_createtime = file_createtime;
	}


	public FileTable(int file_id, String file_name, int file_type, String file_url, String file_user,
			String file_createtime, String file_reporttime) {
		super();
		this.file_id = file_id;
		this.file_name = file_name;
		this.file_type = file_type;
		this.file_url = file_url;
		this.file_user = file_user;
		this.file_createtime = file_createtime;
		this.file_reporttime = file_reporttime;
	}


	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getFile_type() {
		return file_type;
	}
	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getFile_user() {
		return file_user;
	}
	public void setFile_user(String file_user) {
		this.file_user = file_user;
	}

	public String getFile_createtime() {
		return file_createtime;
	}


	public void setFile_createtime(String file_createtime) {
		this.file_createtime = file_createtime;
	}


	public String getFile_reporttime() {
		return file_reporttime;
	}


	public void setFile_reporttime(String file_reporttime) {
		this.file_reporttime = file_reporttime;
	}


	@Override
	public String toString() {
		return "FileTable [file_id=" + file_id + ", file_name=" + file_name + ", file_type=" + file_type + ", file_url="
				+ file_url + ", file_user=" + file_user + ", file_time=" + file_createtime + ", file_ps=" + file_reporttime + "]";
	}
	
	
}
