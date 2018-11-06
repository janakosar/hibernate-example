package com.yana.example.controller;

import com.yana.example.dao.PlayersDao;
import com.yana.example.dao.TeamsDao;
import com.yana.example.model.Player;
import com.yana.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/teams")
public class TeamsRestController {

    private TeamsDao teamsDao;
    private PlayersDao playersDao;

    @Autowired
    public TeamsRestController(TeamsDao teamsDao,
                               PlayersDao playersDao) {
        this.teamsDao = teamsDao;
        this.playersDao = playersDao;
    }

    @GetMapping
    public Iterable<Team> getTeams() {
        return teamsDao.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Team> getTeam(@PathVariable Long id) {
        return teamsDao.findById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamsDao.save(team);
    }

    @PostMapping(path = "/{id}/add")
    public Team addPlayer(@PathVariable Long id,
                          @RequestBody Player player) {

        Optional<Team> teamOptional = teamsDao.findById(id);
        Team team = teamOptional.get();

        Set<Player> players = team.getPlayers();
        players.add(player);

        team.setPlayers(players);


        return teamsDao.save(team);
    }
}
