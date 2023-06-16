package com.amenass.sb_alpos.dto.auth;

import com.amenass.sb_alpos.security.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstname;
  private String lastname;
  @NotEmpty
  @Email
  private String email;
  @NotEmpty
  private String password;
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate dob;
  @NotEmpty
  private Role role;
}
