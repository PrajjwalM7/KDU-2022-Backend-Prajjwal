package com.example.service;

import com.example.jpa.FilmDaoJpa;
import com.example.mapper.FilmMapper;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("usingJpa1")
@Transactional("transactionManager")
public class FilmServiceJPA implements FilmService {


    @Autowired
    private FilmDaoJpa filmDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Film> getFilmsByActor(String firstName, String lastName) {
        return filmDao.findByActorFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toList());
    }

}
