package com.example.jpa;

import com.example.hibernate.entity.ActorEntity;
import com.example.hibernate.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDaoJpa extends JpaRepository<ActorEntity, Long> {

//    @Query(value="SELECT film.* from actor " +
//            "inner join film_actor on actor.actor_id = film_actor.actor_id " +
//            "inner join film on film_actor.film_id = film.film_id " +
//            "where lower(first_name) like ? AND lower(last_name) like ?",nativeQuery = true)
//    List<FilmEntity> findByActorFirstNameAndLastName(String firstName, String lastName);
    List<ActorEntity> findById(int id);
    List<ActorEntity> findByFirstName(String firstName);
}
