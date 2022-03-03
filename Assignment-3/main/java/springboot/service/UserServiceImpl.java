package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.UserDTO;
import springboot.mapper.UserMapper;
import springboot.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDTO findByUserID(String userID) {
        return userMapper.fromEntity(userRepository.findByUserID(userID));
    }

    public List<UserDTO> findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .stream()
                .map(userMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .stream()
                .map(userMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UserDTO> findByContactID(String contactID) {
        return userRepository.findByContactID(contactID)
                .stream()
                .map(userMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
