package com.example.mapper;

import com.example.hibernate.entity.FilmEntity;
import com.example.model.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
        Film film = new Film();
        film.setFilmId(rs.getLong("film_id"));
        film.setDescription(rs.getString("description"));
        film.setRating(rs.getString("rating"));
        film.setTitle(rs.getString("title"));
        film.setYear(rs.getLong("release_year"));
        return film;
    }

    public static Film fromEntity(FilmEntity entity) {
        Film film = new Film();
        film.setYear(entity.getYear());
        film.setFilmId(entity.getId());
        film.setRating(entity.getRating());
        film.setTitle(entity.getTitle());
        film.setDescription(entity.getDescription());
        return film;
    }
}
