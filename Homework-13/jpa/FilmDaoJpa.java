package com.example.jpa;

import com.example.hibernate.entity.ActorEntity;
import com.example.hibernate.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmDaoJpa extends JpaRepository<FilmEntity, Long> {
    @Query(value="SELECT film.* from actor " +
            "inner join film_actor on actor.actor_id = film_actor.actor_id " +
            "inner join film on film_actor.film_id = film.film_id " +
            "where first_name like ? AND last_name like ?",nativeQuery = true)
    List<FilmEntity> findByActorFirstNameAndLastName(String firstName, String lastName);
}
