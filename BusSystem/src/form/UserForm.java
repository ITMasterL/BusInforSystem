package form;

import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private String userID;
	private String username;
	private String password;
	private String repassword;
	private String permission;
	private String ckcode;
	Map<String, String> message = new HashMap<String, String>();
	
	public boolean validate(String checkcode_session) {
		
		if ("".equals(username)) {
			message.put("username", "用户名不能为空！");
		} else if (username.length()<2||username.length()>8) { // 用户名由2-8位字母组成
			message.put("username", "用户名由3-8位字符组成！");
		}

		if ("".equals(password)) {
			message.put("password", "密码不能为空！");
		} else if (!password.matches("\\w{5,10}")) { // 密码由6位以上字母或数字组成
			message.put("password", "密码至少6位字符！");
		}
		
		// 确认密码：密码保持一致
		if (!repassword.equals(password)) {
			message.put("repassword", "密码不一致！");
		}

		if ("".equals(ckcode)) {
			message.put("ckcode","验证码不能为空！");
		}else if (!checkcode_session.equals(ckcode)) {
			message.put("ckcode","验证码不正确！");
			
		}
		return message.isEmpty();
		
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
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
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

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	
}
