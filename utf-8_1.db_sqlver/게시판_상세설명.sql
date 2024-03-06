SELECT * FROM (SELECT rownom r, f.* FROM (
					SELECT * FROM community ORDER BY idx DESC) f)
					WHERE r BETWEEN #{START} AND #{END};

-- step1 idx 내림차순 정렬
SELECT * FROM COMMUNITY c  ORDER BY idx DESC ;
-- step 2 rownum 컬럼값 사용
SELECT rownum r ,f.* FROM (SELECT * FROM COMMUNITY c ORDER BY idx desc) f;


-- step 3. 범위지정. 1페이지에 글이 10개 20 개 보이므로 start, end 값을 그 갯수에 따라 지정.
-- 1페이지의 글 목록이 10개일때는 아래와 같이 실행되어야 함.

SELECT * FROM (SELECT rownum r, f.* FROM (SELECT * FROM COMMUNITY ORDER BY idx DESC)f)
	WHERE r BETWEEN 1 AND 10;

SELECT * FROM (SELECT rownum r, f.* FROM (SELECT * FROM COMMUNITY ORDER BY idx desc)f)
	WHERE r BETWEEN 11 AND 20;

SELECT * FROM (SELECT rownum r, f.* FROM (SELECT * FROM COMMUNITY ORDER BY idx desc)f)
	WHERE r BETWEEN 21 AND 30;

INSERT INTO COMMUNITY (idx, writer,title,CONTENT) VALUES (commuity_idx_seq.nextval, 'wonder')

SELECT community_idx_seq.CURRENT FROM DUAL;

