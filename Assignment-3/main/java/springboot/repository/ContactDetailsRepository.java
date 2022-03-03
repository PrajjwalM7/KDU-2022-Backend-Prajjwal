package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.ContactDetails;

import java.util.List;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, String> {
    ContactDetails findByContactID(String id);
    List<ContactDetails> findByPhone(Integer phone);
    List<ContactDetails> findByEmail(String email);
    List<ContactDetails> findByCity(String city);
    List<ContactDetails> findByState(String state);
    List<ContactDetails> findByCountry(String country);
}
