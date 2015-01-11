package ivyy.taobao.com.excel.domain.poi;

import ivyy.taobao.com.excel.dao.CruiseDao;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;


/**
 *@DEMO:excel-doc-pdf
 *@Java：DoExcel.java
 *@Date:2015-1-11上午10:21:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
@SuppressWarnings("all")
public class DoExcel {
	static CruiseDao cruiseDao = new CruiseDao();
	
	@Test
	public void testDoExcel() throws Exception {
		HSSFWorkbook Workbook=cruiseDao.getCruiseLocationList();
		String filePath = "D:/test/test.xls";
		// 生成文件
		File file = new File(filePath);
		if (!file.exists()) {
			file.exists();
		}
		FileOutputStream fos = null;
		fos = new FileOutputStream(file);
		Workbook.write(fos);
	}
	
}
