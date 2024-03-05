package day7.api;

import java.util.HashMap;
import java.util.Map;

import day7.api.Controller;
import day7.api.RequestMap;

public class RequestControllerMapping {
	
//		key는 url, method로 구성된 RequestMap 객체, value는 Controller	private static final Map<RequestMap, Controller> mapping = new HashMap<>();
	
	// rest api 컨트롤러는 /api로 시작하도록 합시다.
	public static void init() {
		// 기존 동기 통신 컨트롤러
		mapping.put(new RequestMap("/products", "GET"), new ProductsController());
		mapping.put(new RequestMap("/buys", "GET"), new BuysController());
		
		// 비동기 통신을 위한 api 제공 컨트롤러
		mapping.put(new RequestMap("/api/customer/list","GET"), new ApiCustomerListController());
		mapping.put(new RequestMap("/api/customer", "POST"), new ApiCustomerPostController());
		mapping.put(new RequestMap("/api/customer", "GET"), new ApiCustomerGetController());
		mapping.put(new RequestMap("/api/product/list", "GET"), new ApiProductListController());
		mapping.put(new RequestMap("/api/product", "POST"), new ApiProductListController());
		mapping.put(new RequestMap("/api/buy/list", "GET"), new ApiBuyListController());
		// 상품 검색
		mapping.put(new RequestMap("/api/product", "PUT"), new ApiProductSearchController());
	}
	 
	public static Controller getController(RequestMap key) {
		return mapping.get(key);		// value에 해당하는 Controller 객체 리턴
	}

}
