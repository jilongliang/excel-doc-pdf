package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;

/**
 *@DEMO:excel_doc_pdf
 *@Java：CreateExcel.java
 *@Date:2015-1-10下午9:43:49
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：創建一個Excel文件
 */
public class CreateExcel {
	
	@Test
	public void testCreateExcel(String[] args) {
		try {
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls "));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页 ", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			// 以及单元格内容为column,row,count
			Label label = new Label(0, 0, " 東升布藝 ");//column,row,count
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			/*
			 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			 */
			jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
			sheet.addCell(number);
			// 写入数据并关闭文件
			book.write();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
