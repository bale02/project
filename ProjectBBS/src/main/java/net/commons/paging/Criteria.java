package net.commons.paging;

public class Criteria {
	private int start;
	private int end;
	private int page;
	private String skey,sval;
	
	
	public Criteria() {
		this.start=1;
		this.end=10;
		this.page=1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}
	
	
	
	
	
}
