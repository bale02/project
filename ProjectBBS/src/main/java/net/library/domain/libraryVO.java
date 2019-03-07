package net.library.domain;

import java.util.Date;

public class libraryVO {
	private String book_Name;
	private String book_Writer;
	private String book_Publisher;
	private int book_Check;
	private Date book_LimitDate;
	private String user_Id;
	private int book_replycnt;
	private int book_No;
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getBook_Writer() {
		return book_Writer;
	}
	public void setBook_Writer(String book_Writer) {
		this.book_Writer = book_Writer;
	}
	public String getBook_Publisher() {
		return book_Publisher;
	}
	public void setBook_Publisher(String book_Publisher) {
		this.book_Publisher = book_Publisher;
	}
	public int getBook_Check() {
		return book_Check;
	}
	public void setBook_Check(int book_Check) {
		this.book_Check = book_Check;
	}
	public Date getBook_LimitDate() {
		return book_LimitDate;
	}
	public void setBook_LimitDate(Date book_LimitDate) {
		this.book_LimitDate = book_LimitDate;
	}
	public int getBook_No() {
		return book_No;
	}
	public void setBook_No(int book_No) {
		this.book_No = book_No;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public int getBook_replycnt() {
		return book_replycnt;
	}
	public void setBook_replycnt(int book_replycnt) {
		this.book_replycnt = book_replycnt;
	}
	
	
	
	
}
