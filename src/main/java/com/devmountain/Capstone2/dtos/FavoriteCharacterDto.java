package com.devmountain.Capstone2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteCharacterDto {
    private Long favoriteId;
    private Long userId;
    private Long characterId;

    public FavoriteCharacterDto(Long userId, Long characterId) {
        this.userId = userId;
        this.characterId = characterId;
    }

}
