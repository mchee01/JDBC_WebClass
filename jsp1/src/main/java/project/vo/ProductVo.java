package project.vo;


public class ProductVo {
    private String pcode;
	private String category;
	private String pname;
	private int price;
    
    public ProductVo(String string, String string2, String string3, int int1) {
		this.pcode = string;	
		this.category = string2;
		this.pname = string3;
		this.price = int1;
		
	}

	@Override
    public String toString() {
        return String.format("%6s %15s %40s\t %,8d", 
                            category,pcode,pname,price);
    }

    
}
