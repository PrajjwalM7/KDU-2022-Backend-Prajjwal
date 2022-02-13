package springboot.service;

import springboot.dto.StaffListDTO;
import springboot.entity.StaffList;

import java.util.List;

public interface StaffListService {
    StaffListDTO getStaffByID(Long id);
    List<StaffListDTO> getStaffByName(String name);
    List<StaffListDTO> getStaffListByCity(String city);
}
