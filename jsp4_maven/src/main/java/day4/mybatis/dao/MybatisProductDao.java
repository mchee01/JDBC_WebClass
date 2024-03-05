package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {

	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisProductDao() {
		//테스트 db 연결 : 나중에는 지웁니다.
		//SqlSession sqlSession = sessionFactory.openSession();
		//System.out.println("db 연결 및 sql 실행 객체 : " + sqlSession);
	}
	
	public List<ProductDto> search(Map<String,Object> map){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.search",map);
		sqlSession.close();
		return list;
	}
	
	public List<CateDto> getCategories(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
		sqlSession.close();
		return list;
	}
	
	
	public List<ProductDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectAll");
		sqlSession.close();
		return list;
	}
	
	//마이바티스는 auto commit 이 아닙니다.
	public int insert(ProductDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		
		int result = sqlSession.insert("tblproduct.insert",vo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
		
	public int delete(String pcode) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblproduct.delete",pcode);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<ProductDto> selectByCategory(String category){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByCategory",category);
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> selectByPname(String pname){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname",pname);
		sqlSession.close();
		return list;
	}
	
	
	public Map<String, Object> getPriceTable(){
		SqlSession sqlSession = sessionFactory.openSession();
//		Map<String, Object> list = sqlSession.selectMap("tblproduct.getPriceTable");
		sqlSession.close();
		return null;
	}
}