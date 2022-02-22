package springboot.service;


import springboot.dto.ActorDTO;

import java.util.List;

public interface ActorService {
    List<ActorDTO> getActorByID(Long id);
    List<ActorDTO> getActorByFirstName(String name);
}
