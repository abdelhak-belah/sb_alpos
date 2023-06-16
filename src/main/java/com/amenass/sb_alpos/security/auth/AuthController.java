package com.amenass.sb_alpos.security.auth;

import com.amenass.sb_alpos.dto.auth.AuthRequest;
import com.amenass.sb_alpos.dto.auth.RegisterRequest;
import com.amenass.sb_alpos.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

import static com.amenass.sb_alpos.keys.EndpointKey.*;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping(ENDPOINT_REGISTER)
    public ResponseEntity<ResponseUtil> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("tokens", service.register(request)))
                        .message("User registered successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping(ENDPOINT_LOGIN)
    public ResponseEntity<ResponseUtil> login(
            @RequestBody AuthRequest request
    ) {
      return ResponseEntity.ok(
              ResponseUtil.builder()
                      .timeStamp(now())
                      .data(Map.of("tokens", service.login(request)))
                      .message("User logged in successfully")
                      .status(OK)
                      .statusCode(OK.value())
                      .build());
    }

    @PostMapping(ENDPOINT_LOGOUT)
    public ResponseEntity<ResponseUtil> logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException{
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("logout", service.logout(request, response) ))
                        .message("User logged out successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping(ENDPOINT_REFRESH_TOKEN)
    public ResponseEntity<ResponseUtil> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("tokens", service.refreshToken(request, response)))
                        .message("User access token refreshed successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

}
