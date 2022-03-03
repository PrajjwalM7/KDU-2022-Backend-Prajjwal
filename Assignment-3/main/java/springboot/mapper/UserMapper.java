package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.UserDTO;
import springboot.entity.User;

@Component
public class UserMapper {

    public UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setUserName(user.getUserName());
        userDTO.setContactID(user.getContactID());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserID(userDTO.getUserID());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setContactID(userDTO.getContactID());
        return user;
    }
}
