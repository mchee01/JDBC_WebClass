package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    public static void main(String[] args) {
        //1) ojdbc11.jar 라이브러리 프로젝트에 추가
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";       //localhose는 서버의 ip가 바뀔 수 있습니다.
        String user = "SCOTT";
        String password = "tiger";
        try{
            // 2) ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            //      java 6부터 jdbc4.0버전이 지원되고 그 때부터 생략합니다.
            //      DriverManager 가 드라이버 클래스를 알아서 로드합니다.
            Class.forName(driver);              //런타임 시점에 지정된 클래스이름 로드
                                                // ClassNotFoundException 체크드 익셉션 -> 처리필요
            //3) Connection 구현 객체를 생성 -DriverManger는 드라이버 관리하는 유틸리티 클래스
            conn = DriverManager.getConnection(url, user, password);
                                        // SQLException 예외 처리 필요.
            //Connection 은 인터페이스에 대한 구현은 드라이버에 따라 정해짐.
            System.out.println("데이터베이스 연결 객체 :" + conn);
            if (conn != null) {
                System.out.println("Connection 객체의 구현 클래스 :" + conn.getClass().getName());  //Connection 구현 클래스 이름 확인
                                                                    //oracle.jdbc.driver.T4CConnection sms 오라클의 connection 구현 클래스
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        }catch (Exception e){
            System.out.println("예외 발생 : " + e.getMessage());
        }finally{
            try {
                if (conn!=null)conn.close();
            }catch(Exception e) {}
        }
    }
}