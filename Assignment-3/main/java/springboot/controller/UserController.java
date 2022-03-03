package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.RouteDTO;
import springboot.dto.UserDTO;
import springboot.entity.User;
import springboot.service.RouteService;
import springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserByID(@PathVariable String id) {
        return userService.findByUserID(id);
    }

    @GetMapping("/name/{name}")
    public List<UserDTO> getUserByName(@PathVariable String name) {
        return userService.findByUserName(name);
    }
}
