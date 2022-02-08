package com.example.mapper;

import com.example.hibernate.entity.ActorEntity;
import com.example.model.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));
        actor.setLastUpdate(rs.getString("last_update"));
        actor.setActorID(rs.getInt("actor_id"));
        return actor;
    }

    public static Actor fromEntity(ActorEntity entity) {
        Actor actor = new Actor();
        actor.setActorID(entity.getId());
        actor.setFirstName(entity.getFirstName());
        actor.setLastName(entity.getLastName());
        return actor;
    }
}

