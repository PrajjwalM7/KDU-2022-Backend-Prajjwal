package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.StaffListDTO;
import springboot.mapper.StaffListMapper;
import springboot.repository.StaffListRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StaffListServiceImpl implements StaffListService {
    @Autowired
    private StaffListRepository staffListRepository;
    @Autowired
    private StaffListMapper staffListMapper;

    @Override
    public StaffListDTO getStaffByID(Long id) {
        return staffListRepository.findById(id)
                .map(staffListMapper::fromEntity)
                .orElse(null);
    }

    @Override
    public List<StaffListDTO> getStaffByName(String name) {
        return staffListRepository.findByName(name)
                .stream().map(staffListMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffListDTO> getStaffListByCity(String city) {
        return staffListRepository.findByCity(city)
                .stream().map(staffListMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
