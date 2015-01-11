package ivyy.taobao.com.pdf.itext;
/**
 *@Author:jilongliang
 *@Date  :2012-8-12
 *@Project:JAVA7
 *@Description:
 */
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 *@DEMO:excel-doc-pdf
 *@Java：PdfWatermark.java
 *@Date:2015-1-11上午9:53:06
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：pdf生成水印
 */

@SuppressWarnings("all")
public class ReaderPdf {
	public static void main(String[] args) throws Exception {
		String filePath=ReaderPdf.class.getClassLoader().getResource("pdf/pdf.pdf").getPath();
		
		// 待加水印的文件
		PdfReader reader = new PdfReader(filePath);
		
		String newFilePath="D:/test/newPdf.pdf";
		File f=new File(newFilePath);
		if(!f.exists()){
			f.createNewFile();
		}
		
		// 加完水印的文件
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newFilePath));
		int total = reader.getNumberOfPages() + 1;

		PdfContentByte content;
		// 设置字体
		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
		

		//BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED); 
		 //BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
		// 水印文字
		String waterText = "------广东省云浮市闻莺路东升布艺------";
		int leng = waterText.length(); // 文字长度
		char c = 0;
		int height = 0;// 高度
		// 循环对每页插入水印
		for (int i = 1; i < total; i++) {
			// 水印的起始
			height = 500;
			content = stamper.getUnderContent(i);
			// 开始
			content.beginText();
			// 设置颜色
			content.setColorFill(Color.GRAY);
			// 设置字体及字号
			content.setFontAndSize(baseFont, 18);
			// 设置起始位置
			content.setTextMatrix(500, 780);
			// 开始写入水印
			for (int k = 0; k < leng; k++) {
				content.setTextRise(14);
				c = waterText.charAt(k);
				// 将char转成字符串
				content.showText(c + "");
				height -= 5;
			}
			content.endText();
		}
		stamper.close();
	}
}