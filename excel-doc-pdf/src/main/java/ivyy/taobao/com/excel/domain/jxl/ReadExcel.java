package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.Test;

/**
 *@DEMO:excel_doc_pdf
 *@Java：ReadExcel.java
 *@Date:2015-1-10下午9:50:08
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：读取Excel
 */
public class ReadExcel {
	@Test
	public void testReadExcel() {
		try {
			Workbook book = Workbook.getWorkbook(new File("test.xls"));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			Cell cell1 = sheet.getCell(0, 0);
			String result = cell1.getContents();
			System.out.println(result);
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}