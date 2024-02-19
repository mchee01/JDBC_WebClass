package jdbc.day2;

import project.dao.TblBuyDao;
import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.println("[고객관리시스템] 고객을 조회합니다.");
        System.out.println("고객 아이디 입력__");
        String customerId = System.console().readLine();
        System.out.println("\n~~~~~ 조회 결과~~~~~~~~~");
        TblCustomerDao dao =  new TblCustomerDao();
        CustomerVo vo = dao.getCustomer(customerId);
        if (vo == null) 
            System.out.println("조회한 고객이 존재하지 않습니다.");
        else
        System.out.println(vo);
    }
}
