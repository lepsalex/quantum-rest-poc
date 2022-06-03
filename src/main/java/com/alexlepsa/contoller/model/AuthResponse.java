package com.alexlepsa.contoller.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class AuthResponse {
    private Integer resultCode;
    private AuthCookie authCookie;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
    public static class AuthCookie {
        private String token;
    }

    public static AuthResponse authResponseOk(String token) {
        val authCookie = new AuthCookie(token);

        return new AuthResponse(1, authCookie);
    }

    public static AuthResponse authResponseUnauthorized() {
        return new AuthResponse(2, null);
    }
}
