package springboot.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class TransactionDTO implements Serializable {
    private String orderID;
    private String userID;
    private Double amount;
    private Date date;
    private Integer responseCode;
    private String responseMsg;
    private String gateway;
    private String paymentMode;
    private String status;
}
