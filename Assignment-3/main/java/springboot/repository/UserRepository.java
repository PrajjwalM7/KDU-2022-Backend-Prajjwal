package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserID(String userID);
    List<User> findByUserName(String userName);
    List<User> findByEmail(String email);
    List<User> findByContactID(String contactID);
}
