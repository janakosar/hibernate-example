package com.yana.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Player {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "players")
    private Set<Team> teams = new HashSet<>();

}
