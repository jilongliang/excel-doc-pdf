package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;

/**
 * @DEMO:excel_doc_pdf
 * @Java：UpdateExcel.java
 * @Date:2015-1-10下午9:51:11
 * @Author:liangjilong
 * @Email:jilongliang@sina.com
 * @Weibo:http://weibo.com/jilongliang
 * @Version:1.0
 * @Description：
 */
public class UpdateExcel {
	
	@Test
	public  void testUpdateExcel() {
		try {
			// Excel获得文件
			Workbook wb = Workbook.getWorkbook(new File("test.xls"));
			// 打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"), wb);
			// 添加一个工作表
			WritableSheet sheet = book.createSheet("第二页 ", 1);//设置第2个的Sheet
			sheet.addCell(new Label(0, 0, "欢迎到东升布艺购买"));
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
