package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.StaffListDTO;
import springboot.service.StaffListService;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffListController {
    @Autowired
    private StaffListService staffListService;

    @GetMapping("/{id}")
    public StaffListDTO getStaffByID(@PathVariable Long id) {
        return staffListService.getStaffByID(id);
    }

    @GetMapping("/{name}")
    public List<StaffListDTO> getStaffByName(@PathVariable String name) {
        return staffListService.getStaffByName(name);
    }

    @GetMapping("/{city}")
    public List<StaffListDTO> getStaffListByCity(@PathVariable String city) {
        return staffListService.getStaffListByCity(city);
    }
}
