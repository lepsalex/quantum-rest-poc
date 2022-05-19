package com.alexlepsa;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import lombok.val;

import javax.validation.Valid;

@Validated
@Controller("/auth")
public class AuthController {

    @Post("/room")
    public HttpResponse<String> authRoom(@Body @Valid AuthRoomRequest authRoomRequest) {
        if (authRoomRequest.getUserId().equals("goku")) {
            return HttpResponse.ok();
        }

        return HttpResponse.unauthorized();
    }
}
