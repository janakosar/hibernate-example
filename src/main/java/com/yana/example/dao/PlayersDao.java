package com.yana.example.dao;

import com.yana.example.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersDao extends CrudRepository<Player, Long> {
}
