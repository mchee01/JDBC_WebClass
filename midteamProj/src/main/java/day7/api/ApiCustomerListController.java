package day7.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dto.CustomerDto;

// 고객 전체 조회한 것 (List) 자바 객체를 json 문자열로 변환해서 응답으로 보내 줍니다.
//				-> jackson - bind 라이브러리로 매우 쉽게 할 수 있습니다.
public class ApiCustomerListController implements Controller {
	public static final Logger logger = LoggerFactory.getLogger(ApiCustomerListController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MybatisCustomerDao dao = new MybatisCustomerDao();
		List<CustomerDto> list = dao.allCustomers();
		
		//(List) 자바 객체를 json 문자열로 변환
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = null;
		jsonData = objMapper.writeValueAsString(list);
		logger.info("전송할 json 문자열: {}", jsonData);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
	}

}
