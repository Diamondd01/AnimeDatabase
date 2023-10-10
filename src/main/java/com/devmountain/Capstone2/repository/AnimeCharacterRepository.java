package com.devmountain.Capstone2.repository;
import com.devmountain.Capstone2.entites.AnimeCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnimeCharacterRepository extends JpaRepository<AnimeCharacter, Long> {
    List<AnimeCharacter> findByNameContainingIgnoreCase (String query);
}
