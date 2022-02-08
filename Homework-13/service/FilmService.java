package com.example.service;

import com.example.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> getFilmsByActor(String firstName, String lastName);

}
