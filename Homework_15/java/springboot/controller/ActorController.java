package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.ActorDTO;
import springboot.service.ActorService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/{id}")
    public List<ActorDTO> getActorByID(@PathVariable Long id) {
        return actorService.getActorByID(id);
    }

    @GetMapping("/name")
    public List<ActorDTO> getActorByFname(@PathParam("fname") String fname) {
        return actorService.getActorByFirstName(fname);
    }
}
