package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.errors;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {
    private String status;
    private Integer code;
    private Map<String,String> error;
}
