package springboot.service;


import springboot.dto.TransactionDTO;
import springboot.entity.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionDTO findByOrderID(String orderID);
    List<TransactionDTO> findByUserID(String userID);
}
