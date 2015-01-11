package ivyy.taobao.com.pdf.pdfbox;

import java.io.File;
import java.io.FileInputStream;

/**
 * 由于时间问题， pdfbox不整合 一般会建议使用Jacob，Jacob使用会广泛点
 * 参考博客--http://www.cnblogs.com/hejycpu/archive/2009/01/19/1378380.html
 * @author liangjilong
 */
public class PdfFile{    

	public String getContent(File f) throws Exception {
		String content = "";
		FileInputStream fis = new FileInputStream(f);
		// PfbParser p = new PfbParser(fis);
		// InputStream is = p.getInputStream();

		return content;
	 }    
}