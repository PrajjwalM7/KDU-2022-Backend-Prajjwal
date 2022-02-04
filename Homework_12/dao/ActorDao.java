package com.example.dao;

import com.example.model.Actor;
import com.example.model.Film;

import java.util.List;

public interface ActorDao {
    List<Film> getFilmsByActor(String firstName, String lastName);
    List<Actor> getActorsByName(String firstName, String lastName);
    List<Actor> getActorsByID(long ID);
}
