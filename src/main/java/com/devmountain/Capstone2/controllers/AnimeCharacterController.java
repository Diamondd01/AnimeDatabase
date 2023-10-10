package com.devmountain.Capstone2.controllers;

import com.devmountain.Capstone2.dtos.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.devmountain.Capstone2.services.AnimeCharacterService;

import java.util.List;


@RestController
@RequestMapping("api/characters")
@CrossOrigin(origins = "http://localhost:63342")
public class AnimeCharacterController {
    private final AnimeCharacterService animeCharacterService;

    @Autowired
    public AnimeCharacterController(AnimeCharacterService animeCharacterService) {
        this.animeCharacterService = animeCharacterService;
    }

    @GetMapping
    public List<CharacterDto> getAllCharacters() {
        return animeCharacterService.getAllCharacters();
    }

    @GetMapping("search")
    public List<CharacterDto> searchCharacters(@RequestParam("query") String query) {
        return animeCharacterService.searchCharacters(query);
    }
}
