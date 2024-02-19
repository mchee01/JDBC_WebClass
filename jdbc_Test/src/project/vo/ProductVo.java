package project.vo;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class ProductVo {
    private String pcode;
    private String category;
    private String pname;
    private int price;
   
   
    @Override
    public String toString() {
    return String.format("%6s %15s %40s \t %8d", category,pcode,pname,price);
    }
   


}
