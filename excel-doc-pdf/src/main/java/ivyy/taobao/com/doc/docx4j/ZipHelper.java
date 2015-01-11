/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ivyy.taobao.com.doc.docx4j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.apache.commons.io.FileUtils;
/**
 * 
 * @author eg
 */
public class ZipHelper {
	private static final int BUFFER = 1024;
	public void zipFolder(String folderToZip, String destZip,
			boolean includeInitialFolder) throws Exception {
		zipFolder(new File(folderToZip), new File(destZip),
				includeInitialFolder);
	}
	public void zipFolder(String folderToZip, String destZip) throws Exception {
		zipFolder(new File(folderToZip), new File(destZip));
	}
	public static void zipFolder(File folderToZip, File destZip)
			throws Exception {
		zipFolder(folderToZip, destZip, true);
	}
	public static void zipFolder(File folderToZip, File destZip,
			boolean includeInitialFolder) throws Exception {
		ZipFolderHelper helper = new ZipFolderHelper();
		helper.setIncludeInitialFolder(includeInitialFolder);
		helper.process(folderToZip, destZip);
	}
	public static void unzip(String inFile, String outFolder)
			throws IOException {
		unzip(new File(inFile), new File(outFolder));
	}
	/**
	 * @param zipFile
	 * @param dest
	 */
	public static void unzip(File in, File dest) throws ZipException,
			IOException {
		FileUtils.deleteDirectory(dest);
		ZipFile zipFile = new ZipFile(in);
		Enumeration<?> files = zipFile.entries();
		File f = null;
		FileOutputStream fos = null;
		while (files.hasMoreElements()) {
			try {
				ZipEntry entry = (ZipEntry) files.nextElement();
				InputStream eis = zipFile.getInputStream(entry);
				byte[] buffer = new byte[BUFFER];
				int bytesRead = 0;
				f = new File(dest.getAbsolutePath() + File.separator
						+ entry.getName());
				if (entry.isDirectory()) {
					f.mkdirs();
					continue;
				} else {
					f.getParentFile().mkdirs();
					f.createNewFile();
				}
				fos = new FileOutputStream(f);
				while ((bytesRead = eis.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// ignore
					}
				}
			}
		}
	}
}
