package com.devmountain.Capstone2.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

public class CharacterDto {
    private Long characterId;
    private String name;
    private String description;
    private String imageUrl;
    public CharacterDto(Long characterId, String name, String description, String imageUrl) {
        this.characterId = characterId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
