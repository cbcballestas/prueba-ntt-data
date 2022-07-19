package com.nttdata.apirest.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse<T> {
    private String status;
    private String message;
    private T data;
}
