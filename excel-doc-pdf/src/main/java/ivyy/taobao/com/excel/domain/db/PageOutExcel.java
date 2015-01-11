package ivyy.taobao.com.excel.domain.db;


import ivyy.taobao.com.entity.UserInfo;
import ivyy.taobao.com.excel.service.UserInfoService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 经过导出excel测试,每页导出excel最大极限是65536行其中包括头行
 *@DEMO:excel_doc_pdf
 *@Java：PageOutExcel.java
 *@Date:2015-1-10下午9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
public class PageOutExcel {
	public static void main(String[] args) {
		try {
			String sqlWhere = " where 1=1 ";
			// String sqlWhere="where rownum<1000 order by id desc";
			
			UserInfoService cutomerService = new UserInfoService();
			List<UserInfo> userInfoList = cutomerService.getAllUserInfo(sqlWhere);
					
			// 打开文件，没有则创建
			WritableWorkbook book = Workbook.createWorkbook(new File("src/info.xls"));

			int pageNum = 0; // 多少页
			int pageSize = 50000;//每頁五萬條數據
			pageNum = (userInfoList.size() % pageSize > 0) ? (userInfoList.size() / pageSize + 1) : (userInfoList.size() / pageSize);
			
			for (int i = 0; i < pageNum; i++) {
				String[] topText = { "编号", "姓名", "电话信息", "地址" };
				//创建excel区域名称
				WritableSheet sheet = book.createSheet("客户资料" + i, i);
				//i+1是第几页...再乘以pageSize是第N页的尾行的总数行
				int count = (i + 1) * pageSize > userInfoList.size() ? userInfoList.size() : (i + 1) * pageSize;
				
				// System.out.println(i * pageSize);
				// System.out.println(zz);
				for (int z = 0, j = i * pageSize; j < count; j++, z++) {
					
					for (int k = 0; k < topText.length; k++) {
						Label label = new Label(k, 0, topText[k].toString());
						sheet.addCell(label);
						/**
						 * 向Cell填值..
						 */
						UserInfo info = userInfoList.get(j);
						Label id = new Label(0, z + 1, info.getId());
						Label username = new Label(1, z + 1, info.getUsername());
						Label tel = new Label(2, z + 1, info.getTelephone());
						Label address = new Label(3, z + 1, info.getAddress());
						// 将生成的单元格添加到工作表中
						sheet.addCell(id);
						sheet.addCell(username);
						sheet.addCell(tel);
						sheet.addCell(address);
						sheet.setColumnView(8, 28);// 列宽
					}
				}
			}
			book.write();
			book.close();
			System.out.println("数据生成...!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

}
