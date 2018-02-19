package com.example.foo;

import com.example.reactivex.json.JsonService;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

public class FooService {

    private final JsonService jsonService;

    FooService(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    public Single<String> execute() {
        JsonObject foo = new JsonObject().put("foo", "bar");
        return jsonService.rxToJson(foo);
    }

}
