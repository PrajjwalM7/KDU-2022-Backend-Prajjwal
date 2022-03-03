package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.ContactDetailsDTO;
import springboot.entity.ContactDetails;

@Component
public class ContactDetailsMapper {

    public ContactDetailsDTO fromEntity(ContactDetails contactDetails) {
        ContactDetailsDTO contactDetailsDTO = new ContactDetailsDTO();
        contactDetailsDTO.setContactID(contactDetails.getContactID());
        contactDetailsDTO.setCountry(contactDetails.getCountry());
        contactDetailsDTO.setCity(contactDetails.getCity());
        contactDetailsDTO.setEmail(contactDetails.getEmail());
        contactDetailsDTO.setLine1(contactDetails.getLine1());
        contactDetailsDTO.setLine2(contactDetails.getLine2());
        contactDetailsDTO.setState(contactDetails.getState());
        contactDetailsDTO.setPhone(contactDetails.getPhone());
        return contactDetailsDTO;
    }

    public ContactDetails toEntity(ContactDetailsDTO contactDetailsDTO) {
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setContactID(contactDetailsDTO.getContactID());
        contactDetails.setCountry(contactDetailsDTO.getCountry());
        contactDetails.setCity(contactDetailsDTO.getCity());
        contactDetails.setEmail(contactDetailsDTO.getEmail());
        contactDetails.setLine1(contactDetailsDTO.getLine1());
        contactDetails.setLine2(contactDetailsDTO.getLine2());
        contactDetails.setState(contactDetailsDTO.getState());
        contactDetails.setPhone(contactDetailsDTO.getPhone());
        return contactDetails;
    }
}
