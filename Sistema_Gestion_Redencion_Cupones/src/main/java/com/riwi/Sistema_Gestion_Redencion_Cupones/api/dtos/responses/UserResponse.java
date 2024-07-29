package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class UserResponse {

    private Long id;
    private String userName;
    private String email;

}
