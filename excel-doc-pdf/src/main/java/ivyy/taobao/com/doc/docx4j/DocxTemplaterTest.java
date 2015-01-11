package ivyy.taobao.com.doc.docx4j;

import java.io.File;
import java.util.HashMap;
//例子来自Github,原地址忘了,代码被我改过一部分
public class DocxTemplaterTest {
	public static void main(String[] args) {
		DocxTemplater templater = new DocxTemplater("f:/saveFile/temp/test_c");
		File f = new File(
				"f:/saveFile/temp/doc_template.docx");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("TITLE", "这是替换后的文档");
		map.put("XUHAO", "1");
		map.put("NAME", "梅花");
		map.put("NAME2", "杏花");
		map.put("WORD", "问世间情为何物");
		map.put("DATA", "2014-9-28");
		map.put("BOSS", "Github");
		templater.process(f, map);
	}
}
