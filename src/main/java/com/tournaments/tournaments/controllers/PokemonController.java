package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.PokemonDTO;
import com.tournaments.tournaments.services.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PokemonDTO>> getPokemonById(@PathVariable Integer id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping
    public ResponseEntity<PokemonDTO> createdPokemon(@RequestBody PokemonDTO pokemonDTO) {
        return createPokemon(pokemonDTO);
    }

    private ResponseEntity<PokemonDTO> createPokemon(PokemonDTO pokemonDTO) {
        PokemonDTO newPokemon = pokemonService.createPokemon(pokemonDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPokemon.id()).toUri();

        return ResponseEntity.created(location).body(newPokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable Integer id, @RequestBody PokemonDTO pokemonDTO) {
        Optional<PokemonDTO> pokemonUpdated = pokemonService.updatePokemonById(id, pokemonDTO);
        return pokemonUpdated.map(p->ResponseEntity.ok(p))
                .orElseGet(()->
                {return createPokemon(pokemonDTO);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        pokemonService.deletePokemonById(id);
    }
}
