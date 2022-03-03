package springboot.service;


import springboot.dto.UserDTO;
import springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDTO findByUserID(String userID);
    List<UserDTO> findByUserName(String userName);
    List<UserDTO> findByEmail(String email);
    List<UserDTO> findByContactID(String contactID);
}
