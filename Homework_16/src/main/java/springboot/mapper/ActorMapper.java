package springboot.mapper;

import springboot.dto.ActorDTO;
import springboot.dto.FilmDTO;
import springboot.entity.Actor;
import org.springframework.stereotype.Component;
import springboot.entity.Film;

@Component
public class ActorMapper {

    public ActorDTO fromEntity(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(actor.getId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        actorDTO.setLastUpdate(actor.getLastUpdate());
        return actorDTO;
    }

    public Actor toEntity(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setId(actorDTO.getId());
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        actor.setLastUpdate(actorDTO.getLastUpdate());
        return actor;
    }
}
