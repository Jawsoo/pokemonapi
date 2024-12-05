package com.example.pokemonapi.service;

import com.example.pokemonapi.model.Pokemon;
import com.example.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}
