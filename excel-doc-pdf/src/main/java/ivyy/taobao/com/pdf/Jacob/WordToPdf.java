package ivyy.taobao.com.pdf.Jacob;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
/***
 * Java jacob 将Word 生成PDF文件
 * @author liangjilong
 */
public class WordToPdf {

	private ActiveXComponent wordCom = null;
	private Dispatch wordDoc = null;
	private final Variant False = new Variant(false);
	private final Variant True = new Variant(true);

	/**
	 * 打开word文檔
	 * 
	 * @param filePath
	 *            word文檔
	 * @return 返回word文文件对象
	 */
	public boolean openWord(String filePath) {
		// 建立ActiveX部件
		wordCom = new ActiveXComponent("Word.Application");
		try {
			// 返回wrdCom.Documents的Dispatch
			Dispatch wrdDocs = wordCom.getProperty("Documents").toDispatch();
			// 调用wrdCom.Documents.Open方法打开指定的word文檔，返回wordDoc
			wordDoc = Dispatch.invoke(wrdDocs, "Open", Dispatch.Method,
					new Object[] { filePath }, new int[1]).toDispatch();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 关闭word文檔
	 */
	public void closeWord() {
		// 关闭word文件
		if (wordCom != null) {
			int save = 0;
			Variant doNotSaveChanges = new Variant(save);
			wordCom.invoke("Quit", new Variant[] { doNotSaveChanges });
			wordCom = null;
			ComThread.Release();
		}
	}
	
	/**
	 * 删除临时文件
	 */
	public void deletetmpFile(String psfileName,String logFileName){
		File psfile = new File(psfileName);
		
		String  s [] = new String(logFileName).split(".pdf");
		File logfile = new File(s[0]+".log");
		System.out.println(logfile.getName());
		
        if (psfile.exists()) {
        	psfile.delete();
        	System.out.println("删除临时PS文件");
        }
        if(logfile.exists()){
        	logfile.delete();
        	System.out.println("删除临时日志文件");
        }
        
	}

	/**
	 * 将word文檔打印为PS檔后，使用Distiller将PS檔转换为PDF檔
	 * 
	 * @param sourceFilePath
	 *            源文件路径
	 * @param destinPSFilePath
	 *            首先生成的PS文件路径
	 * @param destinPDFFilePath
	 *            生成PDF文件路径
	 */
	public void docToPDF(String sourceFilePath, String destinPSFilePath,
			String destinPDFFilePath) {
		if (!openWord(sourceFilePath)) {
			closeWord();
			return;
		}
		// 建立Adobe Distiller的com对象
		ActiveXComponent distiller = new ActiveXComponent("PDFDistiller.PDFDistiller.1");
		
		try {
			// 设置当前使用的打印机，我的Adobe Distiller打印机名字为"Adobe PDF"
			wordCom.setProperty("ActivePrinter", new Variant("Adobe PDF"));
			
			// 是否在后台运行
			Variant Background = False;
			
			// 是否追加打印
			Variant Append = False;
			
			// 打印所有文檔
			int wdPrintAllDocument = 0;
			
			Variant Range = new Variant(wdPrintAllDocument);
			
			// 输出的postscript文件的路径
			Variant OutputFileName = new Variant(destinPSFilePath);
			
			// 调用word文件对象的PrintOut方法：将word文檔打印为postscript文檔，简称ps文檔
			Dispatch.callN(wordDoc, "PrintOut", new Variant[] { Background,
					Append, Range, OutputFileName });
			
			System.out.println("由word文檔打印为ps文檔成功！");

			// 调用Distiller对象的FileToPDF方法所用的参数，详细内容参考Distiller Api手册
			// 作为输入的ps文文件路径
			Variant inputPostScriptFilePath = new Variant(destinPSFilePath);
			
			// 作为输出的pdf文文件的路径
			Variant outputPDFFilePath = new Variant(destinPDFFilePath);
			
			// 定义FileToPDF方法要使用adobe pdf设置文件的路径，在这里没有赋值表示并不使用pdf配置文件
			Variant PDFOption = new Variant("");
			
			// 调用FileToPDF方法将ps文檔转换为pdf文檔
			Dispatch.callN(distiller, "FileToPDF", new Variant[] {
					inputPostScriptFilePath, outputPDFFilePath, PDFOption });
		
			
			System.out.println("由ps文檔转换为pdf文檔成功！");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeWord();
			deletetmpFile(destinPSFilePath,destinPDFFilePath);
		}
	}

	
	/**
	 */
	@Test
	public void testWordToPdf(){
		String dirPath=WordToPdf.class.getClassLoader().getResource("doc/pdf.doc").getPath();
		String wordPs="d:/test/word.ps";
		String wordPdf="d:/test/word.pdf";
		
		File f1=new File(wordPs);
		
		if(!f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File f2=new File(wordPdf);
		
		if(!f2.exists()){
			try {
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		docToPDF(dirPath,wordPs,wordPdf);
	}
	
 
}