package project.vo;

import java.sql.Timestamp;



public class CustomerBuyVo {
    private int buy_idx;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_date;

    
    public CustomerBuyVo(int int1, String string, String string2, int int2, int int3, Timestamp timestamp) {
		this.buy_idx = int1;
		this.pcode = string;
		this.pname = string2;
		this.price = int2;
		this.quantity = int3;
		this.buy_date = timestamp;
	}


	@Override
    public String toString() {
        return String.format("%8d %-15s %-36s\t %,6d %4d %30s",
                 buy_idx,pcode,pname,price,quantity,buy_date);
    }
}
