package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.TeamPokemonDTO;
import com.tournaments.tournaments.services.TeamPokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teamPokemon")
public class TeamPokemonController {

    private final TeamPokemonService teamPokemonService;

    public TeamPokemonController(TeamPokemonService teamPokemonService) {
        this.teamPokemonService = teamPokemonService;
    }

    @GetMapping
    public ResponseEntity<List<TeamPokemonDTO>> getAllTeamPokemon() {
        return ResponseEntity.ok(teamPokemonService.getAllTeamsPokemon());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TeamPokemonDTO>> getTeamPokemonById(@PathVariable Integer id) {
        return ResponseEntity.ok(teamPokemonService.getTeamPokemonById(id));
    }

    @PostMapping
    public ResponseEntity<TeamPokemonDTO> createdTeamPokemon(@RequestBody TeamPokemonDTO teamPokemonDTO) {
        return createTeamPokemon(teamPokemonDTO);
    }

    private ResponseEntity<TeamPokemonDTO> createTeamPokemon(TeamPokemonDTO teamPokemonDTO) {
        TeamPokemonDTO newTeamPokemonDTO = teamPokemonService.createTeamPokemon(teamPokemonDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTeamPokemonDTO.id()).toUri();

        return ResponseEntity.created(location).body(newTeamPokemonDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeamPokemonDTO> updateTeamPokemon(@PathVariable Integer id, @RequestBody TeamPokemonDTO teamPokemonDTO) {
        Optional<TeamPokemonDTO> updateTeamPokemon = teamPokemonService.updateTeamPokemonById(id, teamPokemonDTO);

        return updateTeamPokemon.map(
                p->ResponseEntity.ok().body(p))
                .orElseGet(()-> {return createTeamPokemon(teamPokemonDTO);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteTeamPokemon(@PathVariable Integer id) {
        teamPokemonService.deleteTeamPokemonById(id);
    }
}
