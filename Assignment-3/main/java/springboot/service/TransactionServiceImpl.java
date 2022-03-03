package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.TransactionDTO;
import springboot.mapper.TransactionMapper;
import springboot.repository.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    public TransactionDTO findByOrderID(String orderID) {
        return transactionMapper.fromEntity(transactionRepository.findByOrderID(orderID));
    }

    public List<TransactionDTO> findByUserID(String userID) {
        return transactionRepository.findByUserID(userID)
                .stream()
                .map(transactionMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
