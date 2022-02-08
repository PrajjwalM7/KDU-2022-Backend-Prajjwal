package com.example.dao;

import com.example.model.Film;

import java.util.List;

public interface FilmDao {
    List<Film> getFilmsByActor(String firstName, String lastName);

}
