package com.example.service;

import com.example.jpa.ActorDaoJpa;
import com.example.jpa.FilmDaoJpa;
import com.example.mapper.ActorMapper;
import com.example.mapper.FilmMapper;
import com.example.model.Actor;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("usingJpa")
@Transactional("transactionManager")
public class ActorServiceJPA implements ActorService {

    @Autowired
    private ActorDaoJpa actorDao;


    @Override
    public List<Actor> getActorsByName(String firstName, String lastName) {
        return actorDao.findByFirstName(firstName)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorsByID(int id) {
        return actorDao.findById(id)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
