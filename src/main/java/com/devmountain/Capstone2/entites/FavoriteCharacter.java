package com.devmountain.Capstone2.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "favoriteCharacter")
@Data
@NoArgsConstructor
public class FavoriteCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "character_Id")
    private AnimeCharacter character;

}
