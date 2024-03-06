package org.iclass.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.iclass.dao.CommunityDao;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class PagingTest {

	@Test
	void test() {
		Paging page = new Paging(2, 258, 10);
		log.info("page property select : {}", page);
	}
	
	@Test
	void getPageList() {
		//2페이지의 글 목록 가져오기
		Paging page = new Paging(2,258,10);
		Map<String, Integer> map = new HashMap<>();
		map.put("start", page.getStartNo());
		map.put("end", page.getEndNo());
		
		CommunityDao dao = CommunityDao.getInstance();
		
		List<Community> list = dao.pagelist(map);
		log.info("2page select by list: {}\n",list);
	}
	
	@Test
	void getArticle() {
		//idx 259 글 가져오기.
		CommunityDao dao= CommunityDao.getInstance();
		Community com = dao.selectByIdx(259);
		log.info("idx for latex 259 list :{}",com);
	}
}
