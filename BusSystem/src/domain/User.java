package domain;

public class User {
	private String userID;
	private String username;
	private String password;
	private String repasseord;
	private String permission;
	private String ckcode;
	public User() {
		super();
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepasseord() {
		return repasseord;
	}
	public void setRepasseord(String repasseord) {
		this.repasseord = repasseord;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getCkcode() {
		return ckcode;
	}
	public void setCkcode(String ckcode) {
		this.ckcode = ckcode;
	}
	
}
