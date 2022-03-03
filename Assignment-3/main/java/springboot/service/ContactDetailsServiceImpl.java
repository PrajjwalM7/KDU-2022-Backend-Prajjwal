package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.ContactDetailsDTO;
import springboot.entity.ContactDetails;
import springboot.mapper.ContactDetailsMapper;
import springboot.repository.ContactDetailsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactDetailsServiceImpl implements ContactDetailsService {
    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Autowired
    private ContactDetailsMapper contactDetailsMapper;

    public ContactDetailsDTO findByContactID(String id) {
        return contactDetailsMapper.fromEntity(contactDetailsRepository.findByContactID(id));
    }

    public List<ContactDetailsDTO> findByPhone(Integer phone) {
        return contactDetailsRepository.findByPhone(phone)
                .stream()
                .map(contactDetailsMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ContactDetailsDTO> findByEmail(String email) {
        return contactDetailsRepository.findByEmail(email)
                .stream()
                .map(contactDetailsMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ContactDetailsDTO> findByCity(String city) {
        return contactDetailsRepository.findByCity(city)
                .stream()
                .map(contactDetailsMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ContactDetailsDTO> findByState(String state) {
        return contactDetailsRepository.findByState(state)
                .stream()
                .map(contactDetailsMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ContactDetailsDTO> findByCountry(String country) {
        return contactDetailsRepository.findByCountry(country)
                .stream()
                .map(contactDetailsMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
