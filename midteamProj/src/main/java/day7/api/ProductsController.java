package day7.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.CateDto;

public class ProductsController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 카테고리 목록 jsp로 보내 주기 (전달)
		MybatisProductDao dao = new MybatisProductDao();
		List<CateDto> cateList = dao.getCategories();	
		request.setAttribute("cateList", cateList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
		dispatcher.forward(request, response);
	}

}
