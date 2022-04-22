package com.alexlepsa;

import io.micronaut.http.annotation.*;

@Controller("/quantumpoc")
public class QuantumpocController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}