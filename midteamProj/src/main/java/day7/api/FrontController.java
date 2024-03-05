 package day7.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import day7.api.Controller;
import day7.api.RequestMap;

@WebServlet(urlPatterns = {"/"}, description = "모든 요청을 받는 서블릿")
public class FrontController extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	// 서블릿이 톰캣에서 실행되기 시작할 때(메모리에 로드될 때) 자동으로 실행하는 메소드
	@Override
	public void init() throws ServletException {
		RequestControllerMapping.init();
	}
	
	
	// get 또는 post 방식 상관없이 요청을 처리하는 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				String url = req.getServletPath();
				String method = req.getMethod();
				 
				logger.info("service 메소드: url - {}, method - {}", url, method);
				RequestMap map = new RequestMap(url, method);
				logger.info("요청 key: {}", map);
				Controller controller = RequestControllerMapping.getController(map);
			 if(controller!=null) {
						logger.info("controller 객체: {}", controller.getClass());
						controller.handle(req, resp);
				
			 }else {
					resp.setContentType("text/html; charset=UTF-8");
					PrintWriter out = resp.getWriter();
//					out.print("<script>");
//					out.print("alert('잘못된 url 요청입니다.');");
//					out.print("location.href='/jsp2_mvc/';");
//					out.print("</script>");
				}
	}
	
	// service와 doGet 모두 동작하는지? 결론: service 메소드만 실행된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				String url = req.getServletPath();
				String method = req.getMethod();
				
				logger.info("doGet 메소드: url - {}, method - {}", url, method);
	}
}


/*
 * if(url.equals("member/join") && method.equals("GET")) {
					// 처리할 내용
					controller = new MemberJoinController();
				} else if (url.equals("member/modify") && method.equals("GET")) {
					controller = new MemberModifyController();
				} else if (url.equals("community/list") && method.equals("GET")) {
					controller = new CommunityListController();
				} else if (url.equals("community/write") && method.equals("GET")) {
					controller = new CommunityWriteController();
				} else if (url.equals("/product/list") && method.equals("GET")) {
					controller = new ProductListController();
				} else if (url.equals("/mypage") && method.equals("GET")) {
					controller = new MyPageController();
				} else if (url.equals("/member/save") && method.equals("POST")) {
					controller = new MemberSaveController();
				}
				
				// 위 if문은 Map을 생성하여 저장하는 방법으로 대체하겠습니다.
				// 				ㄴ key는 url, method로 구성된 RequestMap 객체, value는 Controller
				 
*/
				