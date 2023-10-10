package com.devmountain.Capstone2.dtos;

import com.devmountain.Capstone2.entites.User;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    public Long getUserId() {
        return id;
    }
    public UserDto(User user) {
        this.id = user.getUserId() != null ? user.getUserId() : null;
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

}
