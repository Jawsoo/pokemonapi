package com.example.pokemonapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "type_one")
    private String typeOne;

    @Column(name = "type_two")
    private String typeTwo;

    private int baseAttack;
    private int baseDefense;
    private int baseSpeed;
    private int baseHP;

    private int pokedexNumber;
}
