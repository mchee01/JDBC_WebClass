package mybatis;

import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;

public class MybatisSessionTest {

	public static void main(String[] args) {
		testProduct();
	}
	
	public static void testProduct() {
		MybatisProductDao dao = new MybatisProductDao();
		System.out.println("dao 객체 : " + dao);
		Map<String, Object> map = dao.getPriceTable();
		System.out.println(map);
	}
	
	public static void testCustomer() {
		MybatisCustomerDao dao = new MybatisCustomerDao();
		 System.out.println("dao 객체 : " + dao);
	}
	
	public static void testBuy() {
		MybatisBuyDao dao = new MybatisBuyDao();
		System.out.println("dao 객체 : " + dao);
		System.out.println("===== insert 테스트 =====");
		// int result = dao.insert(new BuyDto(0, "mina012" , "CJBAb12g", 3, null));
		 //System.out.println("반영된 행 개수 : " + result);
		 
		 System.out.println("===== selectAll 테스트 =====");
		 List<BuyDto> list = dao.selectAll();
		 System.out.println(list);
	}
}