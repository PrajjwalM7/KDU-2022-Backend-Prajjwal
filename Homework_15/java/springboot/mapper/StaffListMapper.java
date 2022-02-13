package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.FilmDTO;
import springboot.dto.StaffListDTO;
import springboot.entity.Film;
import springboot.entity.StaffList;

@Component
public class StaffListMapper {
    public StaffListDTO fromEntity(StaffList staffList) {
        StaffListDTO staffListDTO = new StaffListDTO();
        staffListDTO.setId(staffList.getId());
        staffListDTO.setAddress(staffList.getAddress());
        staffListDTO.setCity(staffList.getCity());
        staffListDTO.setSid(staffList.getSid());
        staffListDTO.setCountry(staffList.getCountry());
        staffListDTO.setZipCode(staffList.getZipCode());
        staffListDTO.setName(staffList.getName());
        return staffListDTO;
    }

    public StaffList toEntity(StaffListDTO staffListDTO) {
        StaffList staffList = new StaffList();
        staffList.setId(staffListDTO.getId());
        staffList.setAddress(staffListDTO.getAddress());
        staffList.setCity(staffListDTO.getCity());
        staffList.setSid(staffListDTO.getSid());
        staffList.setCountry(staffListDTO.getCountry());
        staffList.setZipCode(staffListDTO.getZipCode());
        staffList.setName(staffListDTO.getName());
        return staffList;
    }
}
