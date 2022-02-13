package springboot.repository;

import springboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByYear(Long year);

    List<Film> findByTitleLike(String title);

    Set<Film> findByYearOrderByTitle(Long year);

    @Query(value="SELECT film.* from actor " +
            "inner join film_actor on actor.actor_id = film_actor.actor_id " +
            "inner join film on film_actor.film_id = film.film_id " +
            "where first_name like ? AND last_name like ?",nativeQuery = true)
    List<Film> findByActorFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT * FROM film f WHERE f.release_year = :year AND f.rating like :rating", nativeQuery = true)
    Set<Film> findByYearAndRatingLike(Long year, String rating);
}
