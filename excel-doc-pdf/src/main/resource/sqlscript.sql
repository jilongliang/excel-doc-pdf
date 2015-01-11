
create database excel; --创建数据库

drop table userInfo; --删除表

create table userInfo
(
	id int identity(1,1) not null primary key, --顾客编号,主键
	username varchar(1000)not null,     --开户名
	telephone varchar(1445)not null,      --联系电话格式xxxx-xxxxxxxx或手机号11位
	address varchar(2550)   --居住地址,可选输入
)
--CREATE PROCEDURE p_customer AS 
Begin 
	Declare @n bigint 
	Declare @Sql nvarchar(225) 
	set @n=0
	while @n<1000000--导入十万条相同的数据
	begin
		--本数据作为测试.电话号码就用中文,字节会大点,来测试excel到底能存储多少M，不够可以自己改表属性
		Set @Sql='Insert into userInfo Values(''广东云浮东升布艺'',''http://ivyy.taobao.com'',''http://weibo.com/resourceljl'')' 
		Exec (@Sql)  
		set @n=@n+1
	End
end


select count(*) from userinfo;




--Oracle 循环插入测试数据

create  database excel;
drop  table userinfo

create table userinfo(
	id number, --顾客编号,主键
	username varchar2(4000)not null,     --开户名
	telephone varchar2(4000)not null,      --联系电话格式xxxx-xxxxxxxx或手机号11位
	address varchar2(4000)  --居住地址,可选输入
);

--参考循环一
    declare
        maxrecords constant int:=1000;
        i int :=1;
    begin
        for i in 1..maxrecords loop
          insert into UserInfo(UserID,login,password,firstName,lastName,ISADMINISTRATOR)
           values(SYS_GUID(),TO_CHAR('9999'+i),'password','fristname','lastName','0');
        end loop;
      dbms_output.put_line('成功录入数据!');
    commit;
    end;
    
    --SYS_GUID()  生成 GUID ORACLE
	--NEWID   生成 GUID  SQLSERVERR

    ----循环二
    declare
        maxrecords constant int:=100000;--1w
        i int :=1;
        j int :=1;--定义变量累加插入相同的数据
    begin
        for i in 1..maxrecords loop  --for loop循环
           if j=1 then
            dbms_output.put_line('初始化数据');
          end if;
            j:=j+1;
            insert into UserInfo(UserID,login,password,firstName,lastName,ISADMINISTRATOR)
            values(j,TO_CHAR('9999'+i),'password','fristname','lastName','0');
         end loop;
      dbms_output.put_line('成功录入数据!');
    commit;
    end;