package com.example.dev.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    @Size(min = 6, message = "Username must be at least 6 character")
    String username;

    @Size(min = 8, message = "Password must be at least 8 character")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;


}
