package project.vo;

import java.sql.Date;

public class BuyVo {
	private int buyIdx;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buyDate;
	@Override
	public String toString() {
		return "BuyVo [buyIdx=" + buyIdx + ", customid=" + customid + ", pcode=" + pcode + ", quantity=" + quantity
				+ ", buyDate=" + buyDate + "]";
	}
	public int getBuyIdx() {
		return buyIdx;
	}
	public void setBuyIdx(int buyIdx) {
		this.buyIdx = buyIdx;
	}
	public String getCustomid() {
		return customid;
	}
	public void setCustomid(String customid) {
		this.customid = customid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	
	
}
//필드값이 모두 값으면 equals 로 true 가 되도록 하고싶다.
//-> equals 와 hashcode 를 재정의해야 합니다. (vo 객체)
//-> 이러한 객체는 테스트 과정에서 객체를 비교할 때 사용할 수 있습니다.