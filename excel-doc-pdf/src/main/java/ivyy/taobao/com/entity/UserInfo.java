package ivyy.taobao.com.entity;

import java.io.Serializable;
/**
 *@DEMO:excel_doc_pdf
 *@Java£ºUserInfo.java
 *@Date:2015-1-10ÏÂÎç9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description£º
 */
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String telephone;

	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}