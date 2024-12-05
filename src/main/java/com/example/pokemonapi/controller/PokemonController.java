package com.example.pokemonapi.controller;

import com.example.pokemonapi.model.Pokemon;
import com.example.pokemonapi.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id);
    }

    @PostMapping
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.savePokemon(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon existingPokemon = pokemonService.getPokemonById(id);
        if (existingPokemon != null) {
            existingPokemon.setName(pokemon.getName());
            existingPokemon.setTypeOne(pokemon.getTypeOne());
            existingPokemon.setTypeTwo(pokemon.getTypeTwo());
            existingPokemon.setBaseAttack(pokemon.getBaseAttack());
            existingPokemon.setBaseDefense(pokemon.getBaseDefense());
            existingPokemon.setBaseSpeed(pokemon.getBaseSpeed());
            existingPokemon.setBaseHP(pokemon.getBaseHP());
            existingPokemon.setPokedexNumber(pokemon.getPokedexNumber());
            return pokemonService.savePokemon(existingPokemon);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
    }
}
