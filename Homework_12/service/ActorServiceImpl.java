package com.example.service;

import com.example.dao.ActorDao;
import com.example.model.Actor;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    @Qualifier("namedJdbcDao") // Use "jdbcTemplateDao" as qualifier for using jdbcTemplate
    private ActorDao actorDao;

    @Override
    public List<Film> getFilmsByActor(String firstName, String lastName) {
        return actorDao.getFilmsByActor(firstName, lastName).stream().collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorsByName(String firstName, String lastName) {
        return actorDao.getActorsByName(firstName, lastName).stream().collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorsByID(int ID) {
        return actorDao.getActorsByID(ID).stream().collect(Collectors.toList());
    }
}
