package com.alexlepsa.contoller;

import com.alexlepsa.contoller.model.AuthResponse;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;

import java.util.List;

import static com.alexlepsa.contoller.common.AuthUtils.*;
import static com.alexlepsa.contoller.model.AuthResponse.authResponseOk;
import static com.alexlepsa.contoller.model.AuthResponse.authResponseUnauthorized;

@Validated
@Controller("/auth")
@Tag(name = "Auth")
public class AuthController {

    @Post
    public HttpResponse<AuthResponse> auth(@Body String authToken) {
        if (isAccountIdAuthed(authToken)) {
            return HttpResponse.ok(authResponseOk(authToken));
        }

        return HttpResponse.ok(authResponseUnauthorized());
    }

    @Post("/room/{roomId}")
    public HttpResponse<String> authRoom(@Header(AUTH_HEADER) String authToken, String roomId) {
        if (isAccountIdAuthedForRoom(authToken, roomId)) {
            return HttpResponse.ok();
        }

        return HttpResponse.unauthorized();
    }
}
