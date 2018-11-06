package com.yana.example.controller;

import com.yana.example.dao.PlayersDao;
import com.yana.example.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/players")
public class PlayersRestController {

    private PlayersDao playersDao;

    @Autowired
    public PlayersRestController(PlayersDao playersDao) {
        this.playersDao = playersDao;
    }

    @GetMapping
    public Iterable<Player> getPlayers() {
        return playersDao.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Player> getPlayer(@PathVariable Long id) {
        return playersDao.findById(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player team) {
        return playersDao.save(team);
    }
}
