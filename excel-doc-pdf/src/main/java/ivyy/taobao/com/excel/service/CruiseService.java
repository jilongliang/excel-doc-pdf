package ivyy.taobao.com.excel.service;

import ivyy.taobao.com.entity.Cruise;

import java.util.Arrays;
import java.util.List;

/**
 *@DEMO:excel-doc-pdf
 *@Java：CruiseService.java
 *@Date:2015-1-11上午10:21:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
public class CruiseService {

	/**
	 * 获取数据
	 * @return
	 */
	public static List<Cruise> getCruiseLocationList() {
		Cruise csl[] = new Cruise[21];
		csl[0] = new Cruise("T001", "北京市", "北京总部", "bj", "清华大学",
				20);
		csl[1] = new Cruise("T001", "北京市", "北京总部", "bj", "北京大学",
				30);
		csl[2] = new Cruise("T001", "北京市", "海淀经销商", "bjhd",
				"西直门", 15);
		csl[3] = new Cruise("T001", "北京市", "海淀经销商", "bjhd",
				"首都机场", 50);
		csl[4] = new Cruise("T001", "北京市", "海淀经销商", "bjhd",
				"中关村", 23);
		csl[5] = new Cruise("T001", "北京市", "东城经销商", "bjdc",
				"北京火车站", 4);
		csl[6] = new Cruise("T001", "北京市", "东城经销商", "bjdc",
				"北京西站", 12);
		csl[7] = new Cruise("T001", "辽宁省", "大连经销商", "lndl",
				"河口软件园", 15);
		csl[8] = new Cruise("T001", "辽宁省", "大连经销商", "lndl",
				"七贤岭腾飞软件园", 13);
		csl[9] = new Cruise("T001", "辽宁省", "大连经销商", "lndl",
				"高新园区信达街", 11);
		csl[10] = new Cruise("T001", "辽宁省", "大连第二经销商", "lndl2",
				"数码广场", 8);
		csl[11] = new Cruise("T001", "辽宁省", "大连第二经销商", "lndl2",
				"马栏广场", 17);
		csl[12] = new Cruise("T001", "辽宁省", "大连第二经销商", "lndl2",
				"五一广场", 12);
		csl[13] = new Cruise("T001", "辽宁省", "沈阳经销商", "lnsy",
				"沈阳故宫", 16);
		csl[14] = new Cruise("T001", "辽宁省", "沈阳经销商", "lnsy",
				"沈阳北站", 4);
		csl[15] = new Cruise("T001", "吉林省", "长春经销商", "jlcc",
				"吉林大学", 4);
		csl[16] = new Cruise("T001", "吉林省", "长春经销商", "jlcc",
				"长春火车站", 4);
		csl[17] = new Cruise("T002", "黑龙江省", "哈尔滨经销商", "hljhrb",
				"哈工大", 12);
		csl[18] = new Cruise("T002", "黑龙江省", "齐齐哈尔经销商",
				"hljqqhr", "火车站", 21);
		csl[19] = new Cruise("T003", "河北省", "石家庄经销商", "hbsjz",
				"火车站", 4);
		csl[20] = new Cruise("", "", "", "", "", 0);// 合并算法捕捉最后一行有问题，增补一行无效数据，计算时去除

		return Arrays.asList(csl);
	}

}
