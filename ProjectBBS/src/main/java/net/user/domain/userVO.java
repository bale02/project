package net.user.domain;

import java.util.Date;

public class userVO {
	private String user_Id;
	private String user_Pw;
	private String user_Name;
	private String user_Email;
	private Date user_Join_Date;
	private Date user_Login_Date;
	private String userImg;
	private int book_cnt;
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Pw() {
		return user_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		this.user_Pw = user_Pw;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public Date getUser_Join_Date() {
		return user_Join_Date;
	}
	public void setUser_Join_Date(Date user_Join_Date) {
		this.user_Join_Date = user_Join_Date;
	}
	public Date getUser_Login_Date() {
		return user_Login_Date;
	}
	public void setUser_Login_Date(Date user_Login_Date) {
		this.user_Login_Date = user_Login_Date;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public int getBook_cnt() {
		return book_cnt;
	}
	public void setBook_cnt(int book_cnt) {
		this.book_cnt = book_cnt;
	}
	
	
	
	
}
