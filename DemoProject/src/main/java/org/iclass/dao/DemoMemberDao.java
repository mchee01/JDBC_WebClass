package org.iclass.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.DemoMember;

import mybatis.SqlSessionBean;

public class DemoMemberDao {
	private static DemoMemberDao dao = new DemoMemberDao();
	private DemoMemberDao() {}
	public static DemoMemberDao getInstance() {
		return dao;
	}

	public void join(DemoMember member) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		sqlSession.insert("demomember.join",member);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void modify(DemoMember member) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		sqlSession.update("demomember.modify",member);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	public DemoMember login(Map<String, String> map) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		DemoMember vo = sqlSession.selectOne("demomember.login",map);
		sqlSession.close();
		return vo;
	}
	
	public boolean isExistId(String id) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		DemoMember vo = sqlSession.selectOne("demomember.getById",id);
		boolean result=false;
		if (vo!=null) result=true;
		return result;
	}
	
	public DemoMember getById(String id) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		DemoMember vo = sqlSession.selectOne("demomember.getById",id);
		return vo;
	}
	
	public void drop(String id) {
		SqlSession sqlSession = SqlSessionBean.getSession();
		sqlSession.update("demomember.drop",id);
		sqlSession.commit();
		sqlSession.close();
	}
}
