package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.dtos.CharacterDto;
import com.devmountain.Capstone2.entites.FavoriteCharacter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FavoriteCharacterService {

    @Transactional
    List<String> addFavoriteCharacter(Long userId, CharacterDto characterDto);
    List<CharacterDto> getUserFavorites(Long userId);
    @Transactional

        // Method to convert FavoriteCharacter entity to CharacterDto

    CharacterDto convertToCharacterDto(FavoriteCharacter favoriteCharacter);
}
