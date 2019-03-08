package net.reply.domain;

import java.util.Date;

public class bookreplyVO {
	private Integer reply_No;
	private Integer book_No;
	private String reply_Text;
	private String reply_Writer;
	private Date regDate;
	public Integer getReply_No() {
		return reply_No;
	}
	public void setReply_No(Integer reply_No) {
		this.reply_No = reply_No;
	}
	public String getReply_Text() {
		return reply_Text;
	}
	public void setReply_Text(String reply_Text) {
		this.reply_Text = reply_Text;
	}
	public String getReply_Writer() {
		return reply_Writer;
	}
	public void setReply_Writer(String reply_Writer) {
		this.reply_Writer = reply_Writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getBook_No() {
		return book_No;
	}
	public void setBook_No(Integer book_No) {
		this.book_No = book_No;
	}
	
	
}
