package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.ActorDTO;
import springboot.mapper.ActorMapper;
import springboot.repository.ActorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private ActorMapper actorMapper;

    @Override
    public List<ActorDTO> getActorByID(Long id) {
        return actorRepository.findById(id)
                .stream()
                .map(actorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorByFirstName(String name) {
        return actorRepository.findByFirstName(name)
                .stream()
                .map(actorMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
