package net.reply.domain;

import java.util.Date;

public class replyVO {
	private Integer reply_No;
	private Integer board_No;
	private String reply_Text;
	private String reply_Writer;
	private Date regDate;
	private Date update_Date;
	public Integer getReply_No() {
		return reply_No;
	}
	public void setReply_No(Integer reply_No) {
		this.reply_No = reply_No;
	}
	public Integer getBoard_No() {
		return board_No;
	}
	public void setBoard_No(Integer board_No) {
		this.board_No = board_No;
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
	public Date getUpdate_Date() {
		return update_Date;
	}
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
	
	
}
