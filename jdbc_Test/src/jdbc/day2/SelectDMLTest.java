package jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import project.vo.CustomerVo;




public class SelectDMLTest {
    
    public static void main(String[] args) {
        // 테이블 select 결과를 메소드 실행하여 받으면
        //                 그 데이터는 콘솔에서 출력이 되거나 브라우저 화면 출력 또는 다른 목적으로 사용될 수 있습니다.
        List<CustomerVo> result = selectAll_4();
        System.out.println("~~~ 전체 회원 조회 결과~~~");
        System.out.println(result);

    }
    
    
    
        // selectAll_4 : selectAll_3에서 리스트에 담고 출력 
    public static List<CustomerVo> selectAll_4() {
        // 4. 레코드 행 1개를 자바 객체와 1:1로 매핑하기
        List<CustomerVo> list = new ArrayList<>();
        
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_custom";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerVo vo = new CustomerVo(rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getInt(4), 
                                                rs.getDate(5));
                                                list.add(vo);
                
            }
            System.out.println("SELECT 결과 List : " + list);
            // dao 메소드에는 특별한 목적이 아니면 출력문 작성 안합니다.
        } catch (Exception e) {
            System.out.println("select 쿼리 실행 예외 발생 ~ !!" + e.getMessage());
            e.printStackTrace();     
        }
       
        return list;        // select 조회 결과를 자바 객체 List와 매핑하여 리턴.
   
    }











        // selectAll_3 : while & 객체 활용이 특징
    public static void selectAll_3() {
    // 3. 레코드 행 1개를 자바 객체와 1:1로 매핑하기
    Connection connection = OracleConnectionUtil.getConnection();
    String sql = "select * from tbl_custom";
    try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            CustomerVo vo = new CustomerVo(rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getInt(4), 
                                            rs.getDate(5));
            System.out.println(vo);         //      CustomerVo 클래스의 toString 메소드로 출력합니다.
            
        }
        
    } catch (Exception e) {
        System.out.println("select 쿼리 실행 예외 발생 ~ !!" + e.getMessage());
        e.printStackTrace();
        
    }
    

}
    
    
    
    
    
        // selectAll_2 while문 사용하는 것이 특징
    public static void selectAll_2() {
        // 2. rs.next()를 반복해서 레코드 끝까지 위치 이동 확인하기
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "select * from tbl_custom";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();    // 쿼리 실행하고 결과 행 집합을 처리하는 인터페이스 : ResultSet
            int count = 0;

            while (rs.next()) {
                System.out.println("no : " + count++);
                System.out.println("~~~~~~~~~~~~~~~~~~~");
                System.out.println(rs.getString("custom_id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("age"));
                System.out.println(rs.getString("reg_date"));
                System.out.println(rs.getTimestamp("reg_date"));
            }
            System.out.println("총" + count + "개의 레코드 행을 조회 했습니다.");
        } catch (Exception e) {
            System.out.println("select 쿼리 실행 예외 발생 ~ !!" + e.getMessage());
            e.printStackTrace();
        }
        }
        
    




       // selectAll_1 : 일일이 출력하는 것이 특징
    public static void selectAll_1(){
        
        Connection connection = OracleConnectionUtil.getConnection();

        String sql = "select * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();    // 쿼리 실행하고 결과 행 집합을 처리하는 인터페이스 : ResultSet
            
            
            rs.next();      // 결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한 번은 실행해야 할 메소드
                                        // next 메소드는 rs 객체의 다음 행을 접근 할 수 있게 포인터 이동합니다.
            System.out.println(rs.getString(1));    // 1번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(2));    // 2번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(3));    // 3번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getInt(4));    // 4번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getDate(5));    // 5번 인덱스 컬럼 값 가져오기. java.sql.Date를 리턴합니다.
            System.out.println(rs.getTimestamp(5)); // java.sql.Timestamp 리턴
            System.out.println("~~~~~~~~~~~~~~~~~~~");

            rs.next();      // 결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한 번은 실행해야 할 메소드
                                        // next 메소드는 rs 객체의 다음 행을 접근 할 수 있게 포인터 이동합니다.
            System.out.println(rs.getString(1));    // 1번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(2));    // 2번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getString(3));    // 3번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getInt(4));    // 4번 인덱스 컬럼 값 가져오기
            System.out.println(rs.getDate(5));    // 5번 인덱스 컬럼 값 가져오기. java.sql.Date를 리턴합니다.
            System.out.println(rs.getTimestamp(5)); // java.sql.Timestamp 리턴

        } catch (Exception e) {
            System.out.println("select 쿼리 실행 예외 발생 ~ !!" + e.getMessage());
            e.printStackTrace();
        }
    }
}
