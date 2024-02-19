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

import project.vo.CustomerVo;
import project.vo.ProductVo;

public class TblProductDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 2) 카테고리로 검색하기.
    public List<ProductVo> selectByCategory(String category){
          List<ProductVo> list = new ArrayList<>();
            
            String sql = "SELECT * FROM tbl_product\r\n" + "WHERE category = ? \r\n" + "order by pname";
            
            try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, category);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){  // 첫번째 행 조회 결과가 있으면 true, 없으면 false
                    // 할일 : 객체 만들어서 vo 변수에 참조시키기
                    list.add(new ProductVo(rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getInt(4)));
                }
                
            } catch (SQLException e) {
                System.out.println("getCustomer 실행 예외 발생 : " + e.getMessage());
            }
            return list;
            
        }
        
           
        public List<ProductVo> selectByPname(String pname){
            List<ProductVo> list = new ArrayList<>();
              
              String sql = "SELECT * FROM tbl_product\r\n" + 
                            "WHERE pname like '%' || ? || '%'\r\n" +     // like는 유사 비교. % 기호 사용
                             "order by category";
             
              try (
                  Connection conn = getConnection();
                  PreparedStatement ps = conn.prepareStatement(sql);
              ) {
                  ps.setString(1, pname);
                  ResultSet rs = ps.executeQuery();
                  
                  while (rs.next()) {
                    list.add(new ProductVo(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)));
                }

                  
              } catch (SQLException e) {
                  System.out.println("getProduct 실행 예외 발생 : " + e.getMessage());
              }            
        return list;
    }

        public static List<ProductVo> getProductList() {
            return null;
        }

        public Map<String, Integer> getPriceTable() {
            Map<String, Integer> map = new HashMap<>();
            String sql = "select pcode,price from tbl_product";
            try(
                Connection conn = getConnection();
                PreparedStatement psmt = conn.prepareStatement(sql)
            ) {
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    map.put(rs.getString(1),    // key
                    rs.getInt(2));          // value
                }
            } catch (Exception e) {
                System.out.println("getProductList 예외발생 : " + e.getMessage());
            }
            return map;
        }


}
