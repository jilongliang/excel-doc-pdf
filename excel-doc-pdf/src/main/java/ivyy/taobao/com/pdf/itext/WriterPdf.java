package ivyy.taobao.com.pdf.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 *@DEMO:excel-doc-pdf
 *@Java：WriterPdf.java
 *@Date:2015-1-11上午11:42:38
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
public class WriterPdf {
	public static void main(String[] args) {

		System.out.println("东升布艺");
		// 第一步：创建一个document对象。
		Document document = new Document();
		try {
			
			String filePath="D:/test/Writer.Pdf";
			
			File f=new File(filePath);
			
			if(!f.exists()){
				f.createNewFile();
			}
			// 第二步：
			// 创建一个PdfWriter实例，
			// 将文件输出流指向一个文件。
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			// 第三步：打开文档。
			document.open();
			// 第四步：在文档中增加一个段落。
			document.add(new Paragraph("东升布艺" + "," + "东升布艺"+ "," + "东升布艺"));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		// 第五步：关闭文档。
		document.close();
		// 检验程序是否正常运行到这里。
		System.out.println("快去看看吧");
	}    
}
