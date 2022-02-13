package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.StaffList;

import java.util.List;

@Repository
public interface StaffListRepository extends JpaRepository<StaffList, Long> {

    List<StaffList> findByName(String name);
    List<StaffList> findByCity(String city);
}
