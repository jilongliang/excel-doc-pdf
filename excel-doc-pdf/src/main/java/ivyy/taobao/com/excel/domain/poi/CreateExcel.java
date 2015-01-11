package ivyy.taobao.com.excel.domain.poi;
import ivyy.taobao.com.entity.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
/**
 *@DEMO:excel-doc-pdf
 *@Java：CreateExcel.java
 *@Date:2015-1-11上午9:53:06
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：生成Excel示例，2003和2007
 */
public class CreateExcel {
	
	private static List<Student> studentList = null;
	private static Student[] students = new Student[4];
	/**
	 * 静态块初始化数据
	 */
	static {
		studentList = new ArrayList<Student>();
		students[0] = new Student("张三", "男", 23, "一班", 94);
		students[1] = new Student("李四", "女", 20, "一班", 92);
		students[2] = new Student("王五", "男", 21, "一班", 87);
		students[3] = new Student("赵六", "女", 22, "一班", 83);
		studentList.addAll(Arrays.asList(students));
	}
	/**
	 * 创建2003文件的方法
	 * 
	 * @param filePath
	 */
	public static void createExcel2003(String filePath) {
		// 先创建工作簿对象
		HSSFWorkbook workbook2003 = new HSSFWorkbook();
		//------------------------ 设置文本属性  -----------------------
		workbook2003.createInformationProperties();
		SummaryInformation si = workbook2003.getSummaryInformation();
		si.setAuthor("liangjilong");
		si.setTitle("学生信息表");
		si.setComments("POI程序测试");
		DocumentSummaryInformation dsi = workbook2003.getDocumentSummaryInformation();
		dsi.setCompany("Pioneer");

		
		// 创建工作表对象并命名
		HSSFSheet sheet = workbook2003.createSheet("学生信息统计表");
		// 遍历集合对象创建行和单元格
		for (int i = 0; i < studentList.size(); i++) {
			// 取出Student对象
			Student student = studentList.get(i);
			// 创建行
			HSSFRow row = sheet.createRow(i);
			// 开始创建单元格并赋值
			HSSFCell nameCell = row.createCell(0);
			nameCell.setCellValue(student.getName());
			HSSFCell genderCell = row.createCell(1);
			genderCell.setCellValue(student.getGender());
			HSSFCell ageCell = row.createCell(2);
			ageCell.setCellValue(student.getAge());
			HSSFCell sclassCell = row.createCell(3);
			sclassCell.setCellValue(student.getClassz());
			HSSFCell scoreCell = row.createCell(4);
			scoreCell.setCellValue(student.getScore());
		}
		// 生成文件
		File file = new File(filePath);
		if(!file.exists()){
			file.exists();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			workbook2003.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	/***
	 * 创建2007的方法..
	 * @param filePath
	 */
	public static void createExcel2007(String filePath){
		// 创建Excel2007工作簿对象
		XSSFWorkbook workbook2007 = new XSSFWorkbook();
		
		//------------------------ 设置文本属性  -----------------------
        POIXMLProperties.CoreProperties props = workbook2007.getProperties().getCoreProperties();  
        props.setCreator("liangjilong");  
        props.setCategory("POI程序测试");  
        props.setTitle("学生信息表");  
        // 设置扩展属性  
        POIXMLProperties.ExtendedProperties extProps = workbook2007.getProperties().getExtendedProperties();  
        // 设置自定义属性  
        POIXMLProperties.CustomProperties customProps = workbook2007.getProperties().getCustomProperties();  
		
		//------------------ 创建工作表对象并命名------------------
		XSSFSheet sheet = workbook2007.createSheet("学生信息统计表");
		//之后是设置格式：
		// 设置行列的默认宽度和高度
		sheet.setColumnWidth(0, 32 * 80);// 对A列设置宽度为80像素
		sheet.setColumnWidth(1, 32 * 80);
		sheet.setColumnWidth(2, 32 * 80);
		sheet.setColumnWidth(3, 32 * 80);
		sheet.setColumnWidth(4, 32 * 80);
		// -------------------创建样式------------------
		XSSFFont font = workbook2007.createFont();
		XSSFCellStyle headerStyle = workbook2007.createCellStyle();
		// 设置垂直居中
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置边框
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);//加粗
		headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());//对第一行加上红色
		// 字体加粗
		font.setBold(true);
		// 设置长文本自动换行
		headerStyle.setWrapText(true);
		headerStyle.setFont(font);

		// 创建表头
		XSSFRow headerRow = sheet.createRow(0);
		headerRow.setHeightInPoints(25f);// 设置行高度
		XSSFCell nameHeader = headerRow.createCell(0);
		nameHeader.setCellValue("姓名");
		nameHeader.setCellStyle(headerStyle);
		XSSFCell genderHeader = headerRow.createCell(1);
		genderHeader.setCellValue("性别");
		genderHeader.setCellStyle(headerStyle);
		XSSFCell ageHeader = headerRow.createCell(2);
		ageHeader.setCellValue("年龄");
		ageHeader.setCellStyle(headerStyle);
		XSSFCell classHeader = headerRow.createCell(3);
		classHeader.setCellValue("班级");
		classHeader.setCellStyle(headerStyle);
		XSSFCell scoreHeader = headerRow.createCell(4);
		scoreHeader.setCellValue("成绩");
		scoreHeader.setCellStyle(headerStyle);

		// 合并班级
		sheet.addMergedRegion(new CellRangeAddress(1, 4, 3, 3));
		
		for (int i = 0; i < studentList.size(); i++) {
			XSSFRow row = sheet.createRow(i + 1);
			row.setHeightInPoints(20f);
			Student student = studentList.get(i);
			XSSFCell nameCell = row.createCell(0);
			nameCell.setCellValue(student.getName());
			CellStyle cellStyle=row.getRowStyle();
			nameCell.setCellStyle(cellStyle);
			XSSFCell genderCell = row.createCell(1);
			genderCell.setCellValue(student.getGender());
			genderCell.setCellStyle(cellStyle);
			XSSFCell ageCell = row.createCell(2);
			ageCell.setCellValue(student.getAge());
			ageCell.setCellStyle(cellStyle);
			XSSFCell classCell = row.createCell(3);
			classCell.setCellValue(student.getClassz());
			classCell.setCellStyle(cellStyle);
			XSSFCell scoreCell = row.createCell(4);
			scoreCell.setCellValue(student.getScore());
			scoreCell.setCellStyle(cellStyle);
		}
		OutputStream os = null;
		try {
			// 生成文件
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			os = new FileOutputStream(file);
			workbook2007.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	@Test
	public void testExcel2003() {
		long start = System.currentTimeMillis();
		String xls2003="D:/test/office2003.xls";//office2003
		createExcel2003(xls2003);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
	
	@Test
	public void testExcel2007() {
		long start = System.currentTimeMillis();
		String xls2007="D:/test/office2007.xlsx";//office2007
		createExcel2007(xls2007);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
}
