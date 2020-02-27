package app.bean;

public class Book {
	String lib_idid;
	String title;
	String auth;
	String publ;
	String pyb;
	String call_no;
	int brch_code;
	
	public String getLib_idid() {
		return lib_idid;
	}
	public void setLib_idid(String lib_idid) {
		this.lib_idid = lib_idid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPubl() {
		return publ;
	}
	public void setPubl(String publ) {
		this.publ = publ;
	}
	public String getPyb() {
		return pyb;
	}
	public void setPyb(String pyb) {
		this.pyb = pyb;
	}
	public String getCall_no() {
		return call_no;
	}
	public void setCall_no(String call_no) {
		this.call_no = call_no;
	}
	public int getBrch_code() {
		return brch_code;
	}
	public void setBrch_code(int brch_code) {
		this.brch_code = brch_code;
	}
}
