package day6.mvc;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/"},description = "Controller")
public class FrontController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getServletPath();
		String method = req.getMethod();
		
		Controller controller = null;
		if(url.equals("member/join") && method.equals("GET")) {
			controller = new MemberJoinController();
		}else if(url.equals("member/modify")&& method.equals("GET")) {
			controller = new MemberModifyController();
		}else if(url.equals("community/list")&& method.equals("GET")){
			controller = new CommunityListController();
		}
		
	}
}
