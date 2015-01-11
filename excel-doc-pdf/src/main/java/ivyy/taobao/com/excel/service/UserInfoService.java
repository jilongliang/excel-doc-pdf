package ivyy.taobao.com.excel.service;

import ivyy.taobao.com.entity.UserInfo;
import ivyy.taobao.com.excel.dao.UserInfoDao;

import java.util.List;

/**
 *@DEMO:excel_doc_pdf
 *@Java：UserInfoService.java
 *@Date:2015-1-10下午9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
public class UserInfoService   {
	UserInfoDao userInfoDao=new UserInfoDao();
	/**
	 * 获取全部客户
	 */
	public List<UserInfo> getAllUserInfo(String sqlWhere){
		return userInfoDao.getAllUserInfo(sqlWhere);
	}
}
