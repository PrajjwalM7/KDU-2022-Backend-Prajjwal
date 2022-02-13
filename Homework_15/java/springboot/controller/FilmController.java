package springboot.controller;

import springboot.dto.FilmDTO;
import springboot.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmDTO> getById(@PathVariable Long filmId) {
        logger.info("Recieved a request to fetch film with id: {}", filmId);
        return Optional.ofNullable(filmService.getFilmById(filmId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFound());
    }


    private ResponseEntity<FilmDTO> sendNotFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/title")
    public Set<FilmDTO> getFilmByTitle(@PathParam("title") String title) {
        return filmService.getFilmByTitle(title);
    }

    @GetMapping(value = "/")
    public Set<FilmDTO> getFilmByActor(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        return filmService.getFilmByActor(fname, lname);
    }

    @GetMapping(value = "/")
    public List<FilmDTO> getAllFilms(@PathParam("year") Long year, @RequestHeader("x-limit") Integer limit) {
        return filmService.getFilmsOfYear(year, limit);
    }

    @GetMapping(value = "/year")
    public Set<FilmDTO> getFilmByYearAndRating(@PathParam("year") Long year, @PathParam("rating") String rating) {
        return filmService.getFilmByYearAndRating(year, rating);
    }

    @PostMapping(value = "/")
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.createFilm(filmDTO);
    }
}
