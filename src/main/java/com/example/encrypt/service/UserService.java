package com.example.encrypt.service;

import com.example.encrypt.domain.User;
import com.example.encrypt.dto.UserDTO;
import com.example.encrypt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User findByPhoneNumberAndRegion(UserDTO userDTO) {
        return userRepository.findByPhoneNumberAndAndRegion(userDTO.getPhoneNumber(), userDTO.getRegion()).get();
    }


    public User createUser(User user) {
        User createUser = new User();
        createUser.setId(user.getId());
        createUser.setPhoneNumber(user.getPhoneNumber());
        createUser.setRegion(user.getRegion());
        return userRepository.save(createUser);
    }

    public List<User> findbyNative (UserDTO userDTO) {
        return userRepository.findByNative(userDTO.getPhoneNumber(), userDTO.getRegion());
    }
}
