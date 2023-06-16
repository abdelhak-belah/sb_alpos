package com.amenass.sb_alpos.dao.user;

import com.amenass.sb_alpos.dto.user.UserRequest;
import com.amenass.sb_alpos.dto.user.UserResponse;
import com.amenass.sb_alpos.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.amenass.sb_alpos.util.DateUtil.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        users.forEach(user -> userResponses.add(
                        UserResponse.builder()
                                .id(user.getId())
                                .firstName(user.getFirstname())
                                .lastName(user.getLastname())
                                .email(user.getEmail())
                                .role(user.getRole().toString())
                                .dob(format(user.getDob()))
                                .locked(user.getLocked())
                                .build()));
        return userResponses;
    }

    public UserResponse getUser(Integer id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .dob(format(user.getDob()))
                .locked(user.getLocked())
                .build();
    }


    public UserResponse updateUser(UserRequest userRequest){
        var user = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.setFirstname(userRequest.getFirstName());
        user.setLastname(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        if (!userRequest.getDob().equals("")){
            user.setDob(LocalDate.parse(userRequest.getDob()));
        }
        user.setLocked(userRequest.isLocked());
        userRepository.save(user);
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .dob(format(user.getDob()))
                .locked(user.getLocked())
                .build();
    }
}
