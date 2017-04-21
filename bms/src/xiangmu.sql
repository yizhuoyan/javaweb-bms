create table sys_book(
       cid varchar(32) primary key,  --  id  �ı�  7  ����ǿ�
       cname varchar(64) not null,  --  ͼ������  �ı�  20  ����ǿ�
       cisbn varchar(32),  --  ͼ��ISBN��  �ı�  15  ��Ϊ��
       cauthor varchar(64),  --  ͼ������  �ı�  10  ��Ϊ��
       cpublisher varchar(32),  --  ͼ�������  �ı�  20  ��Ϊ��
       cbooktype varchar(32), --  ͼ������  �ı�  16  ��Ϊ��
       fprice double(6,2),  --  ͼ��۸�  ����    ��Ϊ��
       iStoreamount int(8),  --  ͼ������  ����    ��Ϊ��
       iLeftamount int(8) , --  ͼ�鸱������  ����    ��Ϊ��
       //iTotalamount int(8) -- ͼ������
);

create table sys_student(
       cid	varchar(32) primary key,   --   id	�ı�	32	����ǿ�
       cno varchar(16) not null, -- ѧ��
       cname varchar(10) not null,   	--   ѧ������	�ı�	10	����ǿ�
       csex char(1)  not null ,  --  	ѧ���Ա�	�ı�	1	����ǿ�
       enterday date,  --  	ѧ����ѧʱ��	ʱ������		����ǿ�
       graduateday date  --  	ѧ����ҵʱ��	ʱ������		����ǿ�

);

create table log_borrow(
       cid varchar(32) primary key,	 --  id	�ı�	32	����ǿ�
       cstudent_id varchar(32) not null references sys_student(cid),  	--  ѧ�����	�ı�	32	����ǿ�
       cbook_id	varchar(32) not null references sys_book(cid),  	--  ͼ����	�ı�	32	����ǿ�
       BorrowOuttime timestamp,	 --  ���ʱ��	ʱ������		��Ϊ��
       iborrowday int(2),--  ��������
       mustgivebacktime timestamp,--  ���黹����
       givebacktime timestamp,	 --  ʵ�ʻ���ʱ�� 	ʱ������		��Ϊ��
       igivebackerrortype char(1),	--  �黹�쳣����
       cremark varchar(128),	--  �黹����
       borrowoutmanager_id varchar(32) not null,	--  ��� ����Ա
       givebackmanager_id varchar(32)	--  ���� ����Ա	

);

create table sys_manager(
       cid varchar(32) primary key,  --  	id	�ı�	5	����ǿ�
       cname varchar(32) not null, --  	����Ա����	�ı�	10	����ǿ�
       caccount varchar(16) unique  not null,	--  ����Ա�˺�
       cpassword varchar(16) not null,  --  	����	�ı�	6	����ǿ�
       createtime timestamp not null	  --  ����Ա����ʱ��	ʱ������	10	����ǿ�
);

create table sys_publisher(
       cid varchar(32) primary key,  --   id
       cname varchar(32) not null  --   ��������
);

create table sys_type(
       cid varchar(32) primary key,  --   id
       cname varchar(32) not null  --   ����
);


insert into sys_book values(1000001,'ս�����ƽ','978753544044','�ж�˹̩','�������ճ�����','��ѧ',60,5,0);
insert into sys_book values(1000002,'��','9787506261579','�����','����ͼ����湫˾','��ѧ',18,1,1);
insert into sys_book values(1000003,'ƽ��������','9787530209554','·ң','����ʮ�����ճ�����','��ѧ',68,1,0);
insert into sys_book values(1000004,'��������������','7507512355','����.����','���ĳ�����','��ѧ',38,3,2);
insert into sys_book values(1000005,'����Ϧʰ','9787020070305','³Ѹ','������ѧ������','��ѧ',8,1,0);
insert into sys_book values(1000006,'Χ��','7020024750','Ǯ����','������ѧ������','��ѧ',28,2,1);
insert into sys_book values(1000007,'��������','97873751051290','���','�Ϻ����ĳ�����','��ѧ',58,1,0);
insert into sys_book values(1000008,'�����','9787020071029','˾����','������ѧ������','��ѧ',25,2,0);
insert into sys_book values(1000009,'���뷣','9787643520044','','�Ϻ����ĳ�����','��ѧ',26,1,3);
insert into sys_book  values(1000010,'ˮ��ʱ����','9787532134120','����','�Ϻ����ճ�����','��ѧ',35,1,0);

insert into sys_book  values(1000011,'����Ⱥ���̷������о�','9787516202289','������','�й��������Ƴ�����','����',32,1,0);
insert into sys_book  values(1000012,'�����̷�','9787802195882','�Թ�ǿ','�й��������Ƴ�����','����',14,1,0);
insert into sys_book  values(1000013,'�ﷸ����ѧ','9787802196032','����','�й��������Ƴ�����','����',50,1,0);
insert into sys_book  values(1000014,'�������Ƶ��̷�','9787800788505','��ʤ','�й��������Ƴ�����','����',22,1,0);
insert into sys_book  values(1000015,'�����������������ƶ�','7802192250','����','�й��������Ƴ�����','����',20,1,0);


insert into sys_book  values(1000016,'Ƣθ��','9787802312807','���','�й���ҽѧ������','ҽѧ',8,1,0);
insert into sys_book  values(1000017,'��̸ҽʷ','9787560970073','������','���пƼ���ѧ������','ҽѧ',18,1,0);
insert into sys_book  values(1000018,'�ٴ�ҽ���ٲ��ֲ�','9787122111081','����','��ѧ��ҵ������','ҽѧ',45,1,0);
insert into sys_book  values(1000019,'��ϵͳ�ж�','7802192250','�η���','�����ҽ������','ҽѧ',65,1,0);
insert into sys_book  values(1000020,'��Ѫ��ϵͳ','7030096894','����˹','��ѧ������','ҽѧ',29,1,0);

insert into sys_book  values(1000021,'�ϵ۵Ļ�Ц','9787214058478','���˶�','�Ϻ����ĳ�����','��ѧ',25,1,0);
insert into sys_book  values(1000022,'�������','9787540452407','�Ƕ�','�������������','��ѧ',25,1,0);
insert into sys_book  values(1000023,'�ж���ѧ','','����ʿ���','����������','��ѧ',24,1,0);
insert into sys_book  values(1000024,'������������','','�շ�','���������','��ѧ',45,1,0);
insert into sys_book  values(1000025,'�����ѧ','9787560954207','������','���пƼ���ѧ������','��ѧ',33,1,0);
insert into sys_book  values(1000026,'��ѧ���Ѽ�','9787535703453','������','���Ͽ�ѧ����������','��ѧ',17,1,0);
insert into sys_book  values(1000027,'ʱ���ʷ','9787535732309','����','���Ͽ�ѧ����������','��ѧ',45,1,0);
insert into sys_book  values(1000028,'��������','9787542849700','����','�Ϻ��Ƽ�����������','��ѧ',26,1,0);
insert into sys_book  values(1000029,'����ѧ���ʵ�͸��','9787100020220','','����ӡ���','��ѧ',32,1,0);
insert into sys_book  values(1000030,'����ѧ�еĽ���','9787100009201','��ά','����ӡ���','��ѧ',30,1,0);


insert into sys_publisher(cid,cname) values('1','�������ճ�����');
insert into sys_publisher(cid,cname) values('2','����ͼ����湫˾');
insert into sys_publisher(cid,cname) values('3','����ʮ�����ճ�����');
insert into sys_publisher(cid,cname) values('4','���ĳ�����');
insert into sys_publisher(cid,cname) values('6','������ѧ������');
insert into sys_publisher(cid,cname) values('7','�Ϻ����ĳ�����');
insert into sys_publisher(cid,cname) values('8','�Ϻ����ճ�����');
insert into sys_publisher(cid,cname) values('9','�й��������Ƴ�����');
insert into sys_publisher(cid,cname) values('10','�й���ҽѧ������');
insert into sys_publisher(cid,cname) values('11','���пƼ���ѧ������');
insert into sys_publisher(cid,cname) values('12','��ѧ��ҵ������');
insert into sys_publisher(cid,cname) values('13','�����ҽ������');
insert into sys_publisher(cid,cname) values('14','��ѧ������');
insert into sys_publisher(cid,cname) values('15','�Ϻ��Ƽ�����������');
insert into sys_publisher(cid,cname) values('16','�������������');
insert into sys_publisher(cid,cname) values('17','����������');
insert into sys_publisher(cid,cname) values('18','���������');
insert into sys_publisher(cid,cname) values('19','���Ͽ�ѧ����������');
insert into sys_publisher(cid,cname) values('20','����ӡ���');


insert into sys_type(cid,cname) values('1','��ѧ');
insert into sys_type(cid,cname) values('2','С˵');
insert into sys_type(cid,cname) values('3','����');
insert into sys_type(cid,cname) values('4','����');
insert into sys_type(cid,cname) values('5','����');
insert into sys_type(cid,cname) values('6','��ѧ');
insert into sys_type(cid,cname) values('7','ҽѧ');
insert into sys_type(cid,cname) values('8','����');


 
