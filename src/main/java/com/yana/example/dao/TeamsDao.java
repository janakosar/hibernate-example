package com.yana.example.dao;

import com.yana.example.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsDao extends CrudRepository<Team, Long> {
}
