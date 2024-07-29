package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "User name is required")
    @Size(min = 3, max = 50, message = "name exceeds the number of characters allowed(100)")
    private String userName;
    @NotBlank(message = "email is required")
    @Email(message = "the email format must be valid")
    @Size(min = 3, max = 100, message = "email exceeds the number of characters allowed(100)")
    private String email;
    
}
