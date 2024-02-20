package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.ProductVo;

public class TblProductDao {
    
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //2. 카테고리로  검색하기 
	public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n" + 
                     "WHERE CATEGORY =? \r\n" +
                     "ORDER BY PNAME";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
            psmt.setString(1, category);
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  //조회결과는 n행 가능성 예측
			    list.add(new ProductVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByCategory 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    //3. 상품명으로 검색하기 (유사검색-> `검색어가 포함된 상품명`을 조회하기)
	public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n"
                + "WHERE PNAME LIKE '%' || ? || '%' \r\n"      //like는 유사 비교. % 기호 사용
                + "ORDER BY CATEGORY";
        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
		{
            ps.setString(1, pname);
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next()) {
			    list.add(new ProductVo(rs.getString(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByPname 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    // 상품 가격표 Map 에 저장하기
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,price from tbl_product";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  
			   map.put(rs.getString(1),         //key
                       rs.getInt(2));           //value
		    }
        }catch(SQLException e){
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }

        return map;
    }
}
