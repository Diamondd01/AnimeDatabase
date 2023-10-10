package com.devmountain.Capstone2.services;

import com.devmountain.Capstone2.entites.User;
import com.devmountain.Capstone2.dtos.UserDto;
import com.devmountain.Capstone2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("User Added Successfully");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add(String.valueOf(userOptional.get().getUserId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }

    @Override
    public UserDto getCurrentUser() {
        UserDto currentUserDto = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            Optional<User> userOptional = userRepository.findByUsername(userDetails.getUsername());

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                currentUserDto = new UserDto();
                currentUserDto.setId(user.getUserId());
                currentUserDto.setUsername(user.getUsername());

            }
        }

        return currentUserDto;
    }


}
