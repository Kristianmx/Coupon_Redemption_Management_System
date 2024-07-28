package com.riwi.test.api.dtos.errors;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorsListResponse implements Serializable {
    private String status;
    private Integer code;
    private List<Map<String,String>> errors;
}
