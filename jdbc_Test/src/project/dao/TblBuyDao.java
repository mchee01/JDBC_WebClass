package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;


public class TblBuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //executeUpdate 메소드는 insert,update,delete 가 정상 실행되면 1을 리턴,
    //                      특히 update, delete는 조건에 맞는 행이 없어서 반영되는 행이 없으면 0을 리턴

    public int insert(BuyVo vo){
        String sql = "insert into tbl_buy(buy_idx , customid, pcode,quantity,buy_date)\n" +
                    "values (buy_pk_seq.nextval,?,?,?,sysdate)";
        int result=0;
        try (   //auto close
            Connection connection = getConnection();    //1) 서버와의 연결
            PreparedStatement pstmt = connection.prepareStatement(sql); //2) 연결된 서버로 실행할 SQL전달. 서버가 SQL컴파일
        ){
            //매개변수 바인딩
            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());

            result=pstmt.executeUpdate();                                  //3) 연결된 서버에 실행 요청
        } catch (SQLException e) {
            //customid와 pcode는 참조테이블에 존재하는 값으로 안하면 무결성 위반 오류
            System.out.println("insert 실행 예외 발생 : "+ e.getMessage());
        }//finally 없음
        return result;
    }

    

    public int delete(int buy_idx){
        String sql = "DELETE FROM tbl_buy tc WHERE buy_idx = ?";
        int result=0;
        try (   //auto close
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            //매개변수 바인딩
            pstmt.setInt(1, buy_idx);
            result=pstmt.executeUpdate();
            //buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수가 0이다.
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : "+ e.getMessage());
        }//finally 없음
        return result;
    }

    
    public int update(Map<String,Integer> map){//BuyVo vo){
        String sql = "UPDATE tbl_buy SET quantity = ? WHERE buy_idx = ?";
        int result=0;
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setInt(1, map.get("quantity"));
            pstmt.setInt(2, map.get("buyidx"));
            result=pstmt.executeUpdate();
            //buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수가 0이다.
        } catch (SQLException e) {
            System.out.println("update 실행 예외 발생 : "+ e.getMessage());
        }
        return result;
    }

    //mapage기능의 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String customerid){
        List<CustomerBuyVo> list = new ArrayList<>();

        String sql = "SELECT BUY_IDX, tb.PCODE , PNAME, PRICE, QUANTITY,  BUY_DATE \r\n" + 
                "FROM TBL_BUY tb \r\n" + 
                "JOIN TBL_PRODUCT tp \r\n" + 
                "ON tb.PCODE = tp.PCODE \r\n" + 
                "WHERE tb.CUSTOMID =?\r\n" + 
                "ORDER BY BUY_DATE DESC";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setString(1, customerid);
            ResultSet ps = pstmt.executeQuery();
            
            
            while (ps.next()) {
                list.add(new CustomerBuyVo(ps.getInt(1),
                                        ps.getString(2),
                                        ps.getString(3),
                                        ps.getInt(4),
                                        ps.getInt(5),
                                        ps.getTimestamp(6)
                                        ));
            }
            
            // System.out.println("select 결과 : "+list);
            // dao 메소드에는 특별한 목적이 아니면 출력문 작성 안함
        } catch (SQLException e) {
            System.out.println("selectCustomerBuyList 예외 발생 : "+e.getMessage());
            e.printStackTrace();
        }

        return list;
    }


    // 장바구니 모두 구매
    // ㄴ batch(배치)는 일괄처리 : 실행할 insert, update, delete 등의 데이터 저장 DML을 여러개 모아 두었다가 한 번에 실행시킵니다.
    // ㄴ 트랜잭션 : 특정 요구사항에 대한 '하나의 기능'을 실행할 '여러 SQL 명령들'로 구성된 '작업단위'
    //              ㄴ 예시 : cart에 저장된 상품 중 하나라도 참조 값이 없는 pcode가 있으면 rollback, 모두 정상이면 commit
    //                        트랜잭션 commit 모드가 auto에서 수동으로 변경.
    public int insertMany(List<BuyVo> cart){    //여러번의 insert 반복 실행
        String sql = "insert into tbl_buy\n" +  // 위의 insert 복붙하세요.
                    "values (buy_pk_seq.nextval,?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count=0;
        try {
            connection = getConnection();     
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);    // ※ auto 커밋 해제
            for(BuyVo vo : cart){
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();       // ※ sql을 메모리에 모아두기
                count++;
            }

            pstmt.executeBatch();   // ※ 모아둔 sql을 일괄 실행하기. 실행 중에 무결성 오류
            connection.commit();    //      catch에서 rollback
        } catch (SQLException e) {      // 예외발생 : 트랜잭션 처리
            try {
                connection.rollback();
                
            } catch (SQLException e1) {   }
            count =-1;
                System.out.println("구매 불가능한 상품이 있습니다.");
                System.out.println("장바구니 구매 실행 예외 발생 : "+e.getMessage());
        }finally{       // 정상 실행과 예외 모두에 대해 자원 해제
            try {       //트랜잭션  처리를 위해 connection을 사용해야 하므로 직접 close했습니다
                pstmt.close();
                connection.close();
            }catch (SQLException e1) {}
        }
        return count;
    }

      private static void showMyPay(String customerid){
        System.out.println("고객 ID와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.println("고객 ID 입력_");
        String customid = System.console().readLine();

        System.out.println("구매 날짜 입력_");
        String buydate = System.console().readLine();   // 입력형식 yyyy-mm-dd

        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{ call money_of_day(?,?,?) }";
        try(
            CallableStatement cstmt = connection.prepareCall(sql)  
            ) {
            // 프로시저의 IN 매개 변수 값 전달
            cstmt.setString(1, customid); 
            cstmt.setString(2, buydate); 
            
            // 프로시저 OUT 매개변수 1) 타입 설정 
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();  // 프로시저 실행
            // OUT 매개변수 2) 결과 값 가져오기 : getXXX
             
            
            String result = String.format("%s 고객님이 %s 에 구매한 총 구매금액 : %,8d ",
                                                    customid,buydate,cstmt.getInt(3));
            System.out.println(result);

        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }
        
    }

}