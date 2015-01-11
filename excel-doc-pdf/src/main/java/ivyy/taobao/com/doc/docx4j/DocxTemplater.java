package ivyy.taobao.com.doc.docx4j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * 
 * @author eg
 */
public class DocxTemplater {
	private File unzipFolder;
	private File contentXmlFile;
	private String placeholderBefore = "${";
	private String placeholderAfter = "}";
	private static final String PATH_TO_CONTENT = "word/document.xml";
	public DocxTemplater(String pathToDocx, String before, String after) {
		this(new File(pathToDocx), before, after);
	}
	public DocxTemplater(String pathToDocx) {
		this(new File(pathToDocx));
	}
	public DocxTemplater() {
	}
	public DocxTemplater(File unzipFolder) {
		this.unzipFolder = unzipFolder;
	}
	public DocxTemplater(File unzipFolder, String before, String after) {
		this.unzipFolder = unzipFolder;
		this.placeholderBefore = before;
		this.placeholderAfter = after;
	}
	public void process(String destDocx, Map<String, Object> params) {
		process(new File(destDocx), params);
	}
	private void setup(File destDocx) throws IOException {
		ZipHelper.unzip(destDocx, unzipFolder);
		contentXmlFile = new File(unzipFolder, PATH_TO_CONTENT);
	}
	public void process(File destDocx, Map<String, Object> params) {
		try {
			setup(destDocx);
			if (!unzipFolder.exists()) {
				unzipFolder.mkdir();
			}
			if (!contentXmlFile.exists()) {
				throw new FileNotFoundException(
						contentXmlFile.getAbsolutePath());
			}
			String template = FileUtils.readFileToString(contentXmlFile,
					"UTF-8");
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				template = StringUtils.replace(template, placeholderBefore
						+ entry.getKey() + placeholderAfter,
						String.valueOf(entry.getValue()));
			}
			String destDocxString = destDocx.getPath();
			String noExtPathString = destDocxString.substring(0,
					destDocxString.lastIndexOf("."))
					+ "_bak";
			File noExtPath = new File(noExtPathString);
			destDocx.delete();
			FileUtils.deleteDirectory(noExtPath);
			FileUtils.copyDirectory(unzipFolder, noExtPath);
			FileUtils.writeStringToFile(new File(noExtPath, PATH_TO_CONTENT),
					template, "UTF-8");
			ZipHelper.zipFolder(noExtPath, destDocx, false);
			FileUtils.deleteDirectory(noExtPath);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
