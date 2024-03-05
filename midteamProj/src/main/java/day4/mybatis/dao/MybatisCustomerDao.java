package day4.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CustomerDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {
   private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
   
   public int insert(CustomerDto vo) {
      SqlSession sqlSession = sessionFactory.openSession();
      int result = sqlSession.insert("tblcustomer.insert",vo);
      sqlSession.commit();
      sqlSession.close();
      return result;
   }
   
   public List<CustomerDto> update(CustomerDto vo) {
      SqlSession sqlSession = sessionFactory.openSession();
      List<CustomerDto> list = sqlSession.selectList("tblcustomer.update",vo);
      sqlSession.commit();
      sqlSession.close();
      return list;
   }
   
   public int delete(String customerId) {
      SqlSession sqlSession = sessionFactory.openSession();
      int result = sqlSession.delete("tblcustomer.delete", customerId);
      sqlSession.commit();
      sqlSession.close(); 
      return result;
   }
   public CustomerDto getCustomer(String customerId) {
      SqlSession sqlSession = sessionFactory.openSession();
      CustomerDto dto = sqlSession.selectOne("tblcustomer.getCustomer",customerId);
      sqlSession.commit();
      sqlSession.close();
      return dto;
   }
   
   public List<CustomerDto> allCustomers(){
      SqlSession sqlSession = sessionFactory.openSession();
      List<CustomerDto> list = sqlSession.selectList("tblcustomer.allCustomers");
      sqlSession.close();
      return list;
   }
   
   public List<CustomerDto> selectByNameAge(CustomerDto vo){
      SqlSession sqlSession = sessionFactory.openSession();
      List<CustomerDto> list= sqlSession.selectList("tblcustomer.selectByNameAge",vo);
      sqlSession.close();
      return list;
   }
   
   
   
}