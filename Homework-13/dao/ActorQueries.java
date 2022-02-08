package com.example.dao;

public interface ActorQueries {
    String GET_MOVIES_BY_ACTOR = "SELECT film.* FROM actor \n" +
            "INNER JOIN film_actor on actor.actor_id = film_actor.actor_id\n" +
            "INNER JOIN film on film_actor.film_id = film.film_id\n" +
            "WHERE first_name LIKE :firstName AND last_name LIKE :lastName;\n";

    String GET_ACTOR_BY_ID = "SELECT * FROM actor WHERE actor_id IN(:ID);";

    String GET_ACTORS_BY_NAME = "SELECT * FROM actor WHERE first_name = :firstName AND last_name = :lastName;";
}
