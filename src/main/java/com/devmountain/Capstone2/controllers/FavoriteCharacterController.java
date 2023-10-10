package com.devmountain.Capstone2.controllers;

import com.devmountain.Capstone2.dtos.CharacterDto;
import com.devmountain.Capstone2.dtos.UserDto;
import com.devmountain.Capstone2.services.FavoriteCharacterService;
import com.devmountain.Capstone2.services.UserService; // Import UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FavoriteCharacterController {
    private final FavoriteCharacterService favoriteCharacterService;
    private final UserService userService;

    @Autowired
    public FavoriteCharacterController(
            FavoriteCharacterService favoriteCharacterService,
            UserService userService) {
        this.favoriteCharacterService = favoriteCharacterService;
        this.userService = userService;
    }

    @GetMapping("/api/auth/user")
    public ResponseEntity<UserDto> getUserInfo() {
        UserDto userDto = userService.getCurrentUser();
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<String> addFavoriteCharacter(
            @PathVariable Long userId,
            @RequestBody CharacterDto characterDto) {
        // Adds character to the user's favorites
        List<String> response = favoriteCharacterService.addFavoriteCharacter(userId, characterDto);
        if (response.isEmpty()) {
            return ResponseEntity.ok("Character added to favorites.");
        } else {
            String errorMessage = String.join("\n", response);
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
