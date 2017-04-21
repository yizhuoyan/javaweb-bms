create table sys_book(
       cid varchar(32) primary key,  --  id  文本  7  必须非空
       cname varchar(64) not null,  --  图书名称  文本  20  必须非空
       cisbn varchar(32),  --  图书ISBN号  文本  15  可为空
       cauthor varchar(64),  --  图书作者  文本  10  可为空
       cpublisher varchar(32),  --  图书出版社  文本  20  可为空
       cbooktype varchar(32), --  图书类型  文本  16  可为空
       fprice double(6,2),  --  图书价格  货币    可为空
       iStoreamount int(8),  --  图书库存量  整数    可为空
       iLeftamount int(8) , --  图书副本数量  整数    可为空
       //iTotalamount int(8) -- 图书总数
);

create table sys_student(
       cid	varchar(32) primary key,   --   id	文本	32	必须非空
       cno varchar(16) not null, -- 学号
       cname varchar(10) not null,   	--   学生姓名	文本	10	必须非空
       csex char(1)  not null ,  --  	学生性别	文本	1	必须非空
       enterday date,  --  	学生入学时间	时间日期		必须非空
       graduateday date  --  	学生毕业时间	时间日期		必须非空

);

create table log_borrow(
       cid varchar(32) primary key,	 --  id	文本	32	必须非空
       cstudent_id varchar(32) not null references sys_student(cid),  	--  学生编号	文本	32	必须非空
       cbook_id	varchar(32) not null references sys_book(cid),  	--  图书编号	文本	32	必须非空
       BorrowOuttime timestamp,	 --  借出时间	时间日期		可为空
       iborrowday int(2),--  借阅天数
       mustgivebacktime timestamp,--  最大归还期限
       givebacktime timestamp,	 --  实际还书时间 	时间日期		可为空
       igivebackerrortype char(1),	--  归还异常类型
       cremark varchar(128),	--  归还描述
       borrowoutmanager_id varchar(32) not null,	--  借出 管理员
       givebackmanager_id varchar(32)	--  还书 管理员	

);

create table sys_manager(
       cid varchar(32) primary key,  --  	id	文本	5	必须非空
       cname varchar(32) not null, --  	管理员姓名	文本	10	必须非空
       caccount varchar(16) unique  not null,	--  管理员账号
       cpassword varchar(16) not null,  --  	密码	文本	6	必须非空
       createtime timestamp not null	  --  管理员加入时间	时间日期	10	必须非空
);

create table sys_publisher(
       cid varchar(32) primary key,  --   id
       cname varchar(32) not null  --   出版社名
);

create table sys_type(
       cid varchar(32) primary key,  --   id
       cname varchar(32) not null  --   类型
);


insert into sys_book values(1000001,'战争与和平','978753544044','托尔斯泰','长江文艺出版社','文学',60,5,0);
insert into sys_book values(1000002,'简爱','9787506261579','夏洛蒂','世界图书出版公司','文学',18,1,1);
insert into sys_book values(1000003,'平凡的世界','9787530209554','路遥','北京十月文艺出版社','文学',68,1,0);
insert into sys_book values(1000004,'假如给我三天光明','7507512355','海伦.凯勒','华文出版社','文学',38,3,2);
insert into sys_book values(1000005,'朝花夕拾','9787020070305','鲁迅','人民文学出版社','文学',8,1,0);
insert into sys_book values(1000006,'围城','7020024750','钱钟书','人民文学出版社','文学',28,2,1);
insert into sys_book values(1000007,'悲惨世界','97873751051290','雨果','上海译文出版社','文学',58,1,0);
insert into sys_book values(1000008,'红与黑','9787020071029','司汤达','人民文学出版社','文学',25,2,0);
insert into sys_book values(1000009,'罪与罚','9787643520044','','上海译文出版社','文学',26,1,3);
insert into sys_book  values(1000010,'水在时间下','9787532134120','方方','上海文艺出版社','文学',35,1,0);

insert into sys_book  values(1000011,'弱势群体刑法保护研究','9787516202289','曲伶俐','中国民主法制出版社','法制',32,1,0);
insert into sys_book  values(1000012,'澳门刑法','9787802195882','赵国强','中国民主法制出版社','法制',14,1,0);
insert into sys_book  values(1000013,'罪犯心理学','9787802196032','杨威','中国民主法制出版社','法制',50,1,0);
insert into sys_book  values(1000014,'走向完善的刑法','9787800788505','朗胜','中国民主法制出版社','法制',22,1,0);
insert into sys_book  values(1000015,'社区矫正的理论与制度','7802192250','荣容','中国民主法制出版社','法制',20,1,0);


insert into sys_book  values(1000016,'脾胃论','9787802312807','李东恒','中国中医学出版社','医学',8,1,0);
insert into sys_book  values(1000017,'漫谈医史','9787560970073','刘里鹏','华中科技大学出版社','医学',18,1,0);
insert into sys_book  values(1000018,'临床医嘱速查手册','9787122111081','王淘','化学工业出版社','医学',45,1,0);
insert into sys_book  values(1000019,'神经系统中毒','7802192250','何凤生','人民军医出版社','医学',65,1,0);
insert into sys_book  values(1000020,'心血管系统','7030096894','萨恩斯','科学出版社','医学',29,1,0);

insert into sys_book  values(1000021,'上帝的坏笑','9787214058478','迈克尔','上海译文出版社','科学',25,1,0);
insert into sys_book  values(1000022,'神的密码','9787540452407','那多','湖南文译出版社','科学',25,1,0);
insert into sys_book  values(1000023,'行而上学','','亚里士多德','北京出版社','科学',24,1,0);
insert into sys_book  values(1000024,'纯粹理性批判','','赫费','人民出版社','科学',45,1,0);
insert into sys_book  values(1000025,'物理光学','9787560954207','竺子民','华中科技大学出版社','科学',33,1,0);
insert into sys_book  values(1000026,'科学蒙难集','9787535703453','解增泽','湖南科学技术出版社','科学',17,1,0);
insert into sys_book  values(1000027,'时间简史','9787535732309','霍金','湖南科学技术出版社','科学',45,1,0);
insert into sys_book  values(1000028,'解码宇宙','9787542849700','赛费','上海科技教育出版社','科学',26,1,0);
insert into sys_book  values(1000029,'地理学性质的透视','9787100020220','','商务印书馆','科学',32,1,0);
insert into sys_book  values(1000030,'地理学中的解释','9787100009201','哈维','商务印书馆','科学',30,1,0);


insert into sys_publisher(cid,cname) values('1','长江文艺出版社');
insert into sys_publisher(cid,cname) values('2','世界图书出版公司');
insert into sys_publisher(cid,cname) values('3','北京十月文艺出版社');
insert into sys_publisher(cid,cname) values('4','华文出版社');
insert into sys_publisher(cid,cname) values('6','人民文学出版社');
insert into sys_publisher(cid,cname) values('7','上海译文出版社');
insert into sys_publisher(cid,cname) values('8','上海文艺出版社');
insert into sys_publisher(cid,cname) values('9','中国民主法制出版社');
insert into sys_publisher(cid,cname) values('10','中国中医学出版社');
insert into sys_publisher(cid,cname) values('11','华中科技大学出版社');
insert into sys_publisher(cid,cname) values('12','化学工业出版社');
insert into sys_publisher(cid,cname) values('13','人民军医出版社');
insert into sys_publisher(cid,cname) values('14','科学出版社');
insert into sys_publisher(cid,cname) values('15','上海科技教育出版社');
insert into sys_publisher(cid,cname) values('16','湖南文译出版社');
insert into sys_publisher(cid,cname) values('17','北京出版社');
insert into sys_publisher(cid,cname) values('18','人民出版社');
insert into sys_publisher(cid,cname) values('19','湖南科学技术出版社');
insert into sys_publisher(cid,cname) values('20','商务印书馆');


insert into sys_type(cid,cname) values('1','文学');
insert into sys_type(cid,cname) values('2','小说');
insert into sys_type(cid,cname) values('3','传记');
insert into sys_type(cid,cname) values('4','管理');
insert into sys_type(cid,cname) values('5','经济');
insert into sys_type(cid,cname) values('6','科学');
insert into sys_type(cid,cname) values('7','医学');
insert into sys_type(cid,cname) values('8','法制');


 
