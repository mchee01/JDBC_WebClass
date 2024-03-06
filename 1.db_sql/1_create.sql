-- ��ê ���α� ���̺�
create table community(
  idx number(10) NOT NULL,
  writer VARCHAR2(50) NOT NULL,     --�ۼ���(�α��ΰ��� ���� ��)
  title VARCHAR2(100) NOT NULL ,	--������
  content VARCHAR2(3000) NOT NULL,	-- �� ����
  readCount number(10) default '0',    -- ��ȸ��
  createdAt DATE DEFAULT sysdate,       -- �ۼ���¥�ͽð� �⺻��
  ip varchar2(15),  -- �ۼ��� ip
  commentCount number(10) default '0',   --��� ����
  PRIMARY KEY(idx)
);  
create SEQUENCE community_idx_seq;

-- ��ê ������̺�
CREATE TABLE communityComments (
	idx number(10) NOT NULL,   	-- �⺻Ű
	mref number(10) NOT NULL,   -- community ���̺��� idx	
	writer VARCHAR2(50) NOT NULL,	-- �ۼ���
	content VARCHAR2(1000) NOT NULL,  -- ��� ����
	createdAt DATE DEFAULT sysdate,  -- �ۼ���¥�ͽð� �⺻��
	ip VARCHAR2(15),  -- �ۼ��� ip
	heart number(3) DEFAULT '0',	-- ���ƿ� ����
	PRIMARY KEY(idx)
);
CREATE SEQUENCE comment_idx_seq;

-- ��õ����
CREATE TABLE newbooks
   (	idx NUMBER(5,0) NOT NULL ,
	title VARCHAR2(100) NOT NULL ,
	regdate DATE DEFAULT sysdate, 
	coverfile VARCHAR2(300), 
	userid VARCHAR2(20), 
	summary CLOB, 
	 PRIMARY KEY (idx)
);

CREATE SEQUENCE newbooks_idx_seq;

-- ��������
create table notice(
  idx number(10) NOT NULL,
  title VARCHAR2(100) NOT NULL ,	--������
  content VARCHAR2(3000) NOT NULL,	-- �� ����
  readCount number(10) DEFAULT '0',    -- ��ȸ��
  createdAt DATE DEFAULT sysdate,       -- �ۼ���¥�ͽð� �⺻��
  PRIMARY KEY(idx)
);  
create SEQUENCE notice_idx_seq;

-- ȸ��
CREATE TABLE "DEMO_MEMBER" 
   (	"USERID" VARCHAR2(100) NOT NULL , 
	"PASSWORD" CHAR(64) NOT NULL , 
	"NAME" VARCHAR2(100) NOT NULL , 
	"BIRTH" CHAR(8) NOT NULL , 
	"GENDER" VARCHAR2(10) NOT NULL , 
	"PHONE" VARCHAR2(20) NOT NULL , 
	"EMAIL" VARCHAR2(100) NOT NULL , 
	"ADDRESS1" VARCHAR2(100), 
	"ADDRESS2" VARCHAR2(100), 
	"ADULTYN" CHAR(1) NOT NULL , 
	"ADDRESS3" VARCHAR2(100), 
	"ADDRESS4" VARCHAR2(100), 
	"POSTALCODE" VARCHAR2(100), 
	"JOINDATE" DATE DEFAULT sysdate, 
	"FAVORITES" VARCHAR2(200), 
	 CONSTRAINT "DEMO_MEMBER_PK" PRIMARY KEY ("USERID")
);