package springboot.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springboot.entity.Actor;
import springboot.repository.ActorRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void getActorById() throws Exception {
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setFirstName("P");
        actor.setLastName("M");
        actor = actorRepository.save(actor);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getActorsByName() throws Exception {
        Actor actor = new Actor();
        actor.setId(2L);
        actor.setLastName("Mish");
        actor.setFirstName("Pro");
        actor = actorRepository.save(actor);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/name/?fname=Pro")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
