package springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@Table(name="transaction")
public class Transaction {
    @Id
    @Column(name = "order_id")
    private String orderID;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "respcode")
    private Integer responseCode;

    @Column(name = "respmsg")
    private String responseMsg;

    @Column(name = "gateway")
    private String gateway;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "status")
    private String status;
}
