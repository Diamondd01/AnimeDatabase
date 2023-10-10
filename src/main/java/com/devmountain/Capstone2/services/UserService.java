package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);

    UserDto getCurrentUser();
}
