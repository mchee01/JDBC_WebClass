-- å�� : �Ǹ� ����
CREATE TABLE bookcase (
    bcode char(7) NOT NULL,
    title varchar2(100) NOT NULL,
    writer varchar2(100) NOT NULL,
	publisher varchar2(100) NOT NULL,
	pubdate char(10) ,  -- yyyy-mm-dd  string
	saleuser varchar2(100) NOT NULL,
	price number(7) NOT NULL,
	cover varchar2(100) NOT NULL,
	status char(1) DEFAULT 'Y',		--'Y' �Ǹ��� , 'N' �ǸſϷ�
	PRIMARY KEY (bcode),
	FOREIGN KEY (saleuser) REFERENCES demo_member(userid)
);

INSERT INTO bookcase VALUES 
   ('AB10011','������ ������','��ȣ��','����������','2022-05-11','kevin',2000,'������������.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AB10012','�����Ŭ','���̴޸���','�Ѻ�����','2021-04-01','chchch',2300,'�����Ŭ.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AB10301','�������ñ���2','���ù�','�����Ǳ�','2020-05-22','maru080818',3000,'�������ñ���.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AC10011','�̻��Ѱ��ڰ��� ��û��','���νø� ������','��û��','2020-12-11','seri111',1500,'�̻��Ѱ���.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AB10014','��ģ��','�̹���','�����翣��','2020-04-20','minkr',4000,'��ģ��.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AC10012','���ѳ���','�鳭��','���̼���','2022-05-05','minkr',1000,'���ѳ���.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AB10015','���ǰ�','���ͺ񿡸�','���೪��','2021-09-03','nara34',3000,'���ǰ�.jpg','Y');
INSERT INTO bookcase VALUES 
   ('AB10016','���ھƺ�','�ι�Ʈ����Ű','����24','2022-11-22','wonder',3000,'���ھƺ�.jpg','Y');

COMMIT;  
  -- �Ǹ� ����
CREATE TABLE sale_details(
	bcode char(7) NOT NULL,
	orderId varchar2(30) NOT NULL,
	amount number(7) NOT NULL,
	paydate TIMESTAMP,
	buyuser varchar2(100),
	paytype varchar2(100),
	paymentKey varchar2(50),
	FOREIGN KEY (bcode) REFERENCES bookcase(bcode),
	FOREIGN KEY (buyuser) REFERENCES demo_member(userid)
);

INSERT INTO sale_details VALUES ('AB10015_221011121234','2022-06-08 15:40:49','minkr','�ſ� ī��','sx78adg7799');
UPDATE bookcase SET status='N' WHERE bcode='AB10015';
COMMIT;  

-- ÷�����ϸ� ���� �÷�
ALTER TABLE notice ADD "ATTACHFILE" varchar2(200);
ALTER TABLE notice ADD "UPLOADFILE" varchar2(200);
