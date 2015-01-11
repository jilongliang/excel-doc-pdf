
 	由于最近公司项目用到POI，就整理出来的本工程例子代码，除了jxl，大多数是别人写的博客，随便能出来Office（Excel,Word,PDF）
 办公的技术整合一些在网上也没找到一个比较完善的工程代码学习 在前辈上面的例子做了一下修改和处理！在下载本工程之后，必须要懂点
 Maven项目管理技术.如有要改进的地方或者更好操作的Office，请各位指出和建议，共同进步！谢谢！

1、===============poi=============================================
	poi-3.9-20121203.jar
	poi-examples-3.9-20121203.jar
	poi-excelant-3.9-20121203.jar
	poi-ooxml-3.9-20121203.jar
	poi-ooxml-schemas-3.9-20121203.jar
	poi-scratchpad-3.9-20121203.jar
	
	参考博客：http://sarin.iteye.com/blog/845035
	
	   Apache的POI组件是Java操作Microsoft Office办公套件的强大API,其中对Word,Excel和PowperPoint都有支持,
	当然使用较多的还是Excel,因为Word和PowerPoint用程序动态操作的应用较少。那么本文就结合POI来介绍一下操作Excel的方法。 
    Office 2007的文件结构完全不同于2003,所以对于两个版本的Office组件,POI有不同的处理API,分开使用即可。首先来说几个
    Excel的基本概念。对于一个Excel文件,这称为一个工作簿（Workbook）,打开Excel之后,在下方会有sheet1/2/3这样的选项卡,
       点击可以切换到不同的sheet中,这个sheet称作工作表。每个工作表就是我们编辑的区域,这是一张二维表,阿拉伯数字控制行数,
       从1开始,而程序中还是0,类似数组和集合。字母控制列数,从A开始,Z以后是两个字母控制。对于每一行,我们称为Row,列就是
   	Column行列可以确定唯一的一个元素,那么就是单元格,称为Cell。 
       
       POI组件可以方便的操纵这些元素,但初次接触POI可能会有畏惧心理,因为要对每个单元格进行设置,那么不管是用数组还是集合,
       从工作簿,工作表,行下来的代码量都不会小,这是不能避免的,但是按照这个处理顺序走,就一定可以得到结果。有了这些基础的概念
       之后,我们就可以操作Excel了。先来看一下所需的依赖,因为涉及到2007,就要额外加一些依赖。 
	
2、=============jxl===============================================
	jxl.jar
	
	jxl是一个韩国人写的java操作excel的工具, 在开源世界中,有两套比较有影响的API可 供使用,一个是POI,一个是jExcelAPI。
	其中功能相对POI比较弱一点。但jExcelAPI对中文支持非常好,API是纯Java的, 并不 依赖Windows系统,即使运行在Linux下,
	它同样能够正确的处理Excel文件。 另外需要说明的是,这套API对图形和图表的支持很有限,而且 仅仅识别PNG格式。
 	
 	参考博客：http://www.cnblogs.com/raymond19840709/archive/2008/06/26/1230289.html
 	
3、Excel的学习操作.


4、jacob
	1)使用jacob的时候要把C:\Program Files\Java\jdk1.6.0_21\bin的下面，
	    如果是系统是bit32的就拷贝jacob-1.18-M2-x86.dll
	    如果是系统是bit64的就拷贝jacob-1.18-M2-x64.dll
	    據說使用Jacob要安裝微軟的office.Jacob默認是使用office類庫,否则会说找不到
	  jacob-1.18-M2-x86.dll或者jacob-1.18-M2-x64.dll文件，只要能合理使用就不会
	    出现问题
	
	2)web同时也拷贝到tomcat的apache-tomcat-6.0.35\bin
	
	3)如果是web在线阅读的doc文件，需要安装SWFTools，并SWFTools转换PDF为SWF才可以在线阅读.
	  http://www.swftools.org/
	
	  
5、pom.xml的配置jar到maven库搜索加上去即可，maven会自动联网下载添加到项目工程
   http://mvnrepository.com/
   
   
   
   
   
  
  
  
  
  
  
  


