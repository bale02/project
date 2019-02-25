package net.board.domain;

import java.util.Date;

public class boardVO {
	private int board_No;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int reply_Cnt;
	
	public int getBoard_No() {
		return board_No;
	}
	public void setBoard_No(int board_No) {
		this.board_No = board_No;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getReply_Cnt() {
		return reply_Cnt;
	}
	public void setReply_Cnt(int reply_Cnt) {
		this.reply_Cnt = reply_Cnt;
	}
	
	
}
