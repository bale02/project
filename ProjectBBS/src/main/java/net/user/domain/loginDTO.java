package net.user.domain;

public class loginDTO {
	private String user_Id;
	private String user_Pw;
	private boolean useCookie;
	
	
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
	public boolean getUseCookie() {
		return useCookie;
	}
	public void setUserCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	
}
