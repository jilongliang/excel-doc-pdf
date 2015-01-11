package ivyy.taobao.com.excel.service;

import ivyy.taobao.com.entity.Cruise;

import java.util.Arrays;
import java.util.List;

/**
 * 报表数据业务类
 * 
 * 
 */
public class ReportService {
	/**
	 * 获取数据
	 * 
	 * @return
	 */
	public List<Cruise> getCruiseLocationList() {
		Cruise csl[] = new Cruise[21];
		csl[0] = new Cruise("T001", "北京市", "北京总部", "bj", "清华大学",
				20);
		csl[20] = new Cruise("", "", "", "", "", 0);// 合并算法捕捉最后一行有问题，增补一行无效数据，计算时去除

		return Arrays.asList(csl);
	}
}