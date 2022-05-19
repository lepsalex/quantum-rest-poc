package com.alexlepsa.contoller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import static com.alexlepsa.contoller.common.AuthUtils.AUTH_HEADER;
import static com.alexlepsa.contoller.common.AuthUtils.isAccountIdAuthed;

@Validated
@Controller("/auth")
public class AuthController {

    @Post("/room/{roomId}")
    public HttpResponse<String> authRoom(@Header(AUTH_HEADER) String authToken, String roomId) {
        if (isAccountIdAuthed(authToken) && roomId.equals("alex-demo")) {
            return HttpResponse.ok();
        }

        return HttpResponse.unauthorized();
    }
}
