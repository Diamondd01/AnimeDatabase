package com.devmountain.Capstone2.entites;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Character")
@Data
@NoArgsConstructor
public class AnimeCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

   @Column
    private String name;

    @Column (columnDefinition = "text")
    private String description;

    @Column
    private String imageUrl;

}
