package day7.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dto.BuyDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiBuyListController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MybatisBuyDao dao = new MybatisBuyDao();
		List<BuyDto> list = dao.selectAll();
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = null;
		jsonData = objMapper.writeValueAsString(list);
		log.info("전송할 json 문자열: {}", jsonData);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		
	}

}
