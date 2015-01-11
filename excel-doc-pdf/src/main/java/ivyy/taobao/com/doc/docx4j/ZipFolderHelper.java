/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ivyy.taobao.com.doc.docx4j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * 
 * @author eg
 */
class ZipFolderHelper {
	private boolean includeInitialFolder;
	public ZipFolderHelper() {
	}
	public void setIncludeInitialFolder(boolean includeInitialFolder) {
		this.includeInitialFolder = includeInitialFolder;
	}
	public void process(File folderToZip, File destZip) throws Exception {
		if (destZip.exists()) {
			destZip.delete();
		}
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;
		fileWriter = new FileOutputStream(destZip);
		zip = new ZipOutputStream(fileWriter);
		addFolderToZip("", folderToZip.getPath(), zip);
		zip.flush();
		zip.close();
	}
	private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
			throws Exception {
		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			FileInputStream in = null;
			try {
				byte[] buf = new byte[1024];
				int len;
				in = new FileInputStream(srcFile);
				String zeName = path + "/" + folder.getName();
				if (!includeInitialFolder) {
					int idx = zeName.indexOf("/");
					zeName = zeName.substring(idx + 1);
				}
				zip.putNextEntry(new ZipEntry(zeName));
				while ((len = in.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		}
	}
	private void addFolderToZip(String path, String srcFolder,
			ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);
		for (String fileName : folder.list()) {
			if (path.equals("")) {
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/"
						+ fileName, zip);
			}
		}
	}
}
