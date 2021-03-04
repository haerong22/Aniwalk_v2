package com.pandorabox.aniwalk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {
    private int statusCode;
    private T data;

    public static <T> CommonResponse<?> ok(T data) {
        return CommonResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(data)
                .build();
    }

    public static <T> CommonResponse<?> created(T data) {
        return CommonResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .data(data)
                .build();
    }
}
