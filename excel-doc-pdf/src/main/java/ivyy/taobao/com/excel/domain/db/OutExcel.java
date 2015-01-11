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
 * 65535
 *
 *@DEMO:excel_doc_pdf
 *@Java：PageOutExcelTest.java
 *@Date:2015-1-10下午9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：经过导出excel每页导出excel最大极限是65536行其中包括头xin
 */
public class OutExcel {
	public static void main(String[] args) {
		try {
			String sqlWhere = " where 1=1 ";
			// String sqlWhere="where rownum<1000 order by id desc";
			UserInfoService cutomerService = new UserInfoService();
			List<UserInfo> userInfoList = cutomerService
					.getAllUserInfo(sqlWhere);
			// 打开文件，没有则创建
			WritableWorkbook book = Workbook.createWorkbook(new File(
					"src/info1.xls"));
			// 设置表名
			WritableSheet sheet2 = book.createSheet("客户资料2", 0);

			String[] topText = { "编号", "姓名", "职位别", "地址" };
			
			WritableSheet sheet1 = book.createSheet("客户资料1", 1);
			// 生成表格题头
			for (int i = 0; i < topText.length; i++) {
				Label label = new Label(i, 0, topText[i].toString());
				sheet1.addCell(label);
			}
			// 生成表格题头
			for (int i = 0; i < topText.length; i++) {
				Label label = new Label(i, 0, topText[i].toString());
				sheet2.addCell(label);
			}	
			
			// 取得数据生成单元格
			for (int i = 0; i < userInfoList.size(); i++) {
				UserInfo info = userInfoList.get(i);
				if (i <65535) {
					Label id = new Label(0, i + 1, info.getId());
					Label username = new Label(1, i + 1, info.getUsername());
					Label tel = new Label(2, i + 1, info.getTelephone());
					Label address = new Label(3, i + 1, info.getAddress());
					// 将生成的单元格添加到工作表中
					sheet1.addCell(id);
					sheet1.addCell(username);
					sheet1.addCell(tel);
					sheet1.addCell(address);
				} else {
					
					//int count=userInfoList.size()-5000;
					Label id = new Label(0, (i + 1)-65535, info.getId());
					Label username = new Label(1, (i + 1)-65535, info.getUsername());
					Label tel = new Label(2,(i + 1)-65535, info.getTelephone());
					Label address = new Label(3, (i + 1)-65535, info.getAddress());
					// 将生成的单元格添加到工作表中
					sheet2.addCell(id);
					sheet2.addCell(username);
					sheet2.addCell(tel);
					sheet2.addCell(address);
				}
			}
			sheet2.setColumnView(7, 20);// 列宽
			book.write();
			book.close();
			System.out.println("数据生成");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

}
