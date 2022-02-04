package com.example.dao;

import com.example.mapper.ActorMapper;
import com.example.mapper.FilmMapper;
import com.example.model.Actor;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

@Repository("jdbcTemplateDao")
public class ActorDaoImpl implements ActorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmsByActor(String firstName, String lastName) {
        return jdbcTemplate.query(ActorQueries.GET_MOVIES_BY_ACTOR,
                new Object[]{firstName, lastName},
                new int[]{Types.VARCHAR, Types.VARCHAR},
                new FilmMapper());
    }

    @Override
    public List<Actor> getActorsByName(String firstName, String lastName) {
        return jdbcTemplate.query(ActorQueries.GET_ACTORS_BY_NAME,
                new Object[]{firstName, lastName},
                new int[]{Types.VARCHAR, Types.VARCHAR},
                new ActorMapper());
    }

    @Override
    public List<Actor> getActorsByID(long ID) {
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_ID,
                new Object[]{ID},
                new int[]{Types.INTEGER},
                new ActorMapper());
    }
}
