package com.amenass.sb_alpos.dao.user;

import com.amenass.sb_alpos.dto.user.UserRequest;
import com.amenass.sb_alpos.keys.EndpointKey;
import com.amenass.sb_alpos.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor
@RequestMapping(EndpointKey.ENDPOINT_USER)
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<ResponseUtil> getAllUsers() {
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("users", userService.getAllUsers()))
                        .message("Users retrieved successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getUser(
            @Param("id") Integer id
    ) {
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("user", userService.getUser(id)))
                        .message("User retrieved successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin
    @PutMapping("")
    public ResponseEntity<ResponseUtil> updateUser(
            @RequestBody UserRequest userRequest
    ){
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("user", userService.updateUser(userRequest)))
                        .message("User updated successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
