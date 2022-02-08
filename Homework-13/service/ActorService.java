package com.example.service;

import com.example.model.Actor;
import com.example.model.Film;

import java.util.List;

public interface ActorService {
//    List<Film> getFilmsByActor(String firstName, String lastName);
    List<Actor> getActorsByName(String firstName, String lastName);
    List<Actor> getActorsByID(int ID);
}
