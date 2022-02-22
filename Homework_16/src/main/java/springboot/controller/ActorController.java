package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.ActorDTO;
import springboot.dto.FilmDTO;
import springboot.service.ActorService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ActorDTO>> getActorByID(@PathVariable Long id) {
        return Optional.ofNullable(actorService.getActorByID(id))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

    private ResponseEntity<List<ActorDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/name")
    public List<ActorDTO> getActorByFname(@PathParam("fname") String fname) {
        return actorService.getActorByFirstName(fname);
    }
}
