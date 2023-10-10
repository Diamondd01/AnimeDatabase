package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.dtos.CharacterDto;
import com.devmountain.Capstone2.entites.AnimeCharacter;
import com.devmountain.Capstone2.repository.AnimeCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeCharacterServiceImpl implements AnimeCharacterService {

    @Autowired
    private AnimeCharacterRepository animeCharacterRepository;
//gets charecters from the database
    @Override
    @Transactional
    public List<CharacterDto> getAllCharacters() {
        List<AnimeCharacter> characters = animeCharacterRepository.findAll();
        return characters.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public CharacterDto getCharecterById(Long charecterId) {
        AnimeCharacter character = animeCharacterRepository.findById(charecterId)
                .orElse(null);
        if (character != null) {
            return convertToDto(character);
        }
        return null;
    }

    @Override
    @Transactional
    public List<CharacterDto> searchCharacters(String query) {
        List<AnimeCharacter> matchingCharacters = animeCharacterRepository.findByNameContainingIgnoreCase(query);

        return matchingCharacters.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CharacterDto convertToDto(AnimeCharacter character) {
        return new CharacterDto(
                character.getId(),
                character.getName(),
                character.getDescription(),
                character.getImageUrl()
        );
    }


}
