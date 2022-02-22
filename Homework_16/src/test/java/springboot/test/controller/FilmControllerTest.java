package springboot.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springboot.entity.Film;
import springboot.repository.FilmRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void getFilmById() throws Exception {
        Film film = new Film();
        film.setId(1L);
        film.setYear(2020L);
        film.setTitle("ABC");
        film.setDescription("XYZ");
        film.setRating("A");
        film = filmRepository.save(film);
        System.out.println("Inserted new film with id: " + film.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getFilmByTitle() throws Exception {
        Film film = new Film();
        film.setId(2L);
        film.setYear(2020L);
        film.setTitle("ABC");
        film.setDescription("XYZ");
        film.setRating("A");
        film = filmRepository.save(film);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/title/?title=ABC")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getFilmByAbsentId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getFilmByYearAndRating() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/yearAndRating/?year=2020&rating=A").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk());
    }

    @Test
    public void getFilmByAbsentYearAndRating() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/yearAndRating/?year=2029&rating=ABC").
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk());
    }
}
