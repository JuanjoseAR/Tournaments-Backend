package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.entities.PokemonType;
import com.tournaments.tournaments.services.PokemonTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemonType")
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonType>> getAllPokemonTypes() {
        return ResponseEntity.ok(pokemonTypeService.getAllPokemonTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PokemonType>> getPokemonTypeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(pokemonTypeService.getPokemonTypeById(id));
    }

    @PostMapping
    public ResponseEntity<PokemonType> createdPokemonType(@RequestBody PokemonType pokemonType) {
        return createPokemonType(pokemonType);

    }

    private ResponseEntity<PokemonType> createPokemonType(PokemonType pokemonType) {
        PokemonType newPokemonType = pokemonTypeService.createPokemonType(pokemonType);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPokemonType.getId()).toUri();

        return ResponseEntity.created(location).body(newPokemonType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonType> updatedPokemonType(@PathVariable("id") Integer id, @RequestBody PokemonType pokemonType) {
        Optional<PokemonType> pokeType = pokemonTypeService.updatePokemonTypeById(id, pokemonType);
        return pokeType.map(a->ResponseEntity.ok().body(a))
                .orElseGet(()->
                {return createPokemonType(pokemonType);
        });

    }


    @DeleteMapping("/{id}")
    public void deletePokemonType(@PathVariable("id") Integer id) {
        pokemonTypeService.deletePokemonTypeById(id);
    }
}
