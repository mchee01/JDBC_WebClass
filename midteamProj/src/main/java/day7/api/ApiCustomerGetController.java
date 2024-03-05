package day7.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiCustomerGetController implements Controller {

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			MybatisCustomerDao dao = new MybatisCustomerDao();
			CustomerDto dto = dao.getCustomer(request.getParameter("id"));
			log.info("getCustomer dto: {}", dto);
			
			// (List) 자바 객체를 json 문자열로 변환
			// 1) 아이디 중복 검사가 아닌 고객 조회이면 사용하기 
			ObjectMapper objMapper = new ObjectMapper();
			String jsonData = null;
			jsonData = objMapper.writeValueAsString(dto);
			log.info("전송할 json 문자열: {}", jsonData);
			
			int result = 0;
			if(dto!=null) result = 1;
			// 2) 아이디 중복 검사인 경우에는 json으로 있다 또는 없다에 대한 값으로 전달하기
			jsonData = "{ \"result\": "+result+" }";
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonData);
		}

}
