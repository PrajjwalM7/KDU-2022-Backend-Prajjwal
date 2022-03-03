package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.TransactionDTO;
import springboot.entity.Transaction;

@Component
public class TransactionMapper {

    public TransactionDTO fromEntity(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setGateway(transaction.getGateway());
        transactionDTO.setOrderID(transaction.getOrderID());
        transactionDTO.setPaymentMode(transaction.getPaymentMode());
        transactionDTO.setResponseCode(transaction.getResponseCode());
        transactionDTO.setResponseMsg(transaction.getResponseMsg());
        transactionDTO.setStatus(transaction.getStatus());
        transactionDTO.setUserID(transaction.getUserID());
        return transactionDTO;
    }

    public Transaction toEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getDate());
        transaction.setGateway(transactionDTO.getGateway());
        transaction.setOrderID(transactionDTO.getOrderID());
        transaction.setPaymentMode(transactionDTO.getPaymentMode());
        transaction.setResponseCode(transactionDTO.getResponseCode());
        transaction.setResponseMsg(transactionDTO.getResponseMsg());
        transaction.setStatus(transactionDTO.getStatus());
        transaction.setUserID(transactionDTO.getUserID());
        return transaction;
    }
}
