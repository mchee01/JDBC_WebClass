package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME = "SCOTT";
    public static final String PASSWORD = "tiger";

    // Connection 타입 객체 생성하는 메소드.
    //  OracleConnection conn = OracleConnectionUtil.getConnection(); 로 사용할 것 입니다.
    public static Connection getConnection() {
        Connection conn = null;
        try{
            //2) ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            Class.forName(DRIVER);              //런타임 시점에 지정된 클래스이름 로드
                                                // ClassNotFoundException 체크드 익셉션 -> 처리필요
            //3) Connection 구현 객체를 생성 -DriverManger는 드라이버 관리하는 유틸리티 클래스
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            System.out.println("데이터베이스 연결 예외 발생했습니다. \n\t : " + e.getMessage());
        }
    
    return conn;
    }
   
   
    // 실행 순서 : 1)getConnection      2) SQL 실행     3) close
    // SQL 실행 : 개발 프로그램에서 가장 많이 실행하는 SQL은 DML 입니다.(select,insert,update,delete)
    //             OracleConnectionUtil 은 1), 3)에서 사용될 것입니다.

    // 인자로 전달된 Connection 객체를 close. sql 실행이 종료되면 close 해야합니다.
    public static void close(Connection conn){
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 해제 예외 발생 \n\t : " + e.getMessage());
        }
    }
}