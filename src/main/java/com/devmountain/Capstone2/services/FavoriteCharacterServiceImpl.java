package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.entites.User;
import com.devmountain.Capstone2.entites.FavoriteCharacter;
import com.devmountain.Capstone2.repository.FavoriteCharacterRepository;
import com.devmountain.Capstone2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.devmountain.Capstone2.dtos.CharacterDto;
@Service
public class FavoriteCharacterServiceImpl implements FavoriteCharacterService {
    private UserRepository userRepository;
    private FavoriteCharacterRepository favoriteCharacterRepository;

    @Autowired
    public FavoriteCharacterServiceImpl(UserRepository userRepository, FavoriteCharacterRepository favoriteCharacterRepository) {
        this.userRepository = userRepository;
        this.favoriteCharacterRepository = favoriteCharacterRepository;
    }

    @Override
    @Transactional
    public List<String> addFavoriteCharacter(Long userId, CharacterDto characterDto) {
        List<String> response = new ArrayList<>();

        // Retrieve the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Create a new favoriteCharacter entity and set the user
            FavoriteCharacter favoriteCharacter = new FavoriteCharacter();
            favoriteCharacter.setUser(user);

            favoriteCharacterRepository.saveAndFlush(favoriteCharacter);

            response.add("Favorite Character Added Successfully");
        } else {
            response.add("User not found");
        }

        return response;
    }

    @Override
    @Transactional

        // Method to convert FavoriteCharacter entity to CharacterDto
    public CharacterDto convertToCharacterDto(FavoriteCharacter favoriteCharacter) {
            CharacterDto characterDto = new CharacterDto();
            characterDto.setCharacterId(favoriteCharacter.getCharacter().getId()); // Updated field name to getId()
            characterDto.setName(favoriteCharacter.getCharacter().getName());
            characterDto.setDescription(favoriteCharacter.getCharacter().getDescription());
            characterDto.setImageUrl(favoriteCharacter.getCharacter().getImageUrl());
            return characterDto;
        }
    @Override
    public List<CharacterDto> getUserFavorites(Long userId) {
        // Retrieve favorite characters
        List<FavoriteCharacter> favoriteCharacters = favoriteCharacterRepository.findByUser_UserId(userId);

        List<CharacterDto> favoriteCharacterDtos = favoriteCharacters.stream()
                .map(this::convertToCharacterDto)
                .collect(Collectors.toList());

        return favoriteCharacterDtos;
    }


    }
