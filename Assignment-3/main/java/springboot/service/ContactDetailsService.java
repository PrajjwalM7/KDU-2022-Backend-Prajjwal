package springboot.service;

import springboot.dto.ContactDetailsDTO;
import springboot.entity.ContactDetails;

import java.util.List;

public interface ContactDetailsService {
    ContactDetailsDTO findByContactID(String id);
    List<ContactDetailsDTO> findByPhone(Integer phone);
    List<ContactDetailsDTO> findByEmail(String email);
    List<ContactDetailsDTO> findByCity(String city);
    List<ContactDetailsDTO> findByState(String state);
    List<ContactDetailsDTO> findByCountry(String country);
}
