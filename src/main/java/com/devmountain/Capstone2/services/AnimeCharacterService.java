package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.dtos.CharacterDto;
import com.devmountain.Capstone2.entites.AnimeCharacter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnimeCharacterService {
    //gets charecters from the database
    @Transactional
    List<CharacterDto> getAllCharacters();

    @Transactional
    CharacterDto getCharecterById(Long charecterId);

    @Transactional
    List<CharacterDto> searchCharacters(String query);

    CharacterDto convertToDto(AnimeCharacter character);
}
