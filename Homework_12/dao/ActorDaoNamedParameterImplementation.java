package com.example.dao;

import com.example.mapper.ActorMapper;
import com.example.mapper.FilmMapper;
import com.example.model.Actor;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository("namedJdbcDao")
public class ActorDaoNamedParameterImplementation implements ActorDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoNamedParameterImplementation(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmsByActor(String firstName, String lastName) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("firstName", firstName);
        bindParameters.put("lastName", lastName);
        return jdbcTemplate.query(ActorQueries.GET_MOVIES_BY_ACTOR,
                bindParameters,
                new FilmMapper());
    }

    @Override
    public List<Actor> getActorsByName(String firstName, String lastName) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("firstName", firstName);
        bindParameters.put("lastName", lastName);
        return jdbcTemplate.query(ActorQueries.GET_ACTORS_BY_NAME,
                bindParameters,
                new ActorMapper());
    }

    @Override
    public List<Actor> getActorsByID(long ID) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("ID", ID);
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_ID,
                bindParameters,
                new ActorMapper());
    }
}
