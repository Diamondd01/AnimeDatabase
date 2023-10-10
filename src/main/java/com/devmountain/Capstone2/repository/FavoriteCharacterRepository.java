package com.devmountain.Capstone2.repository;
 import com.devmountain.Capstone2.entites.FavoriteCharacter;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;
 import java.util.List;
@Repository
public interface FavoriteCharacterRepository extends JpaRepository<FavoriteCharacter, Long> {
 List<FavoriteCharacter> findByUser_UserId(Long userId);
}

