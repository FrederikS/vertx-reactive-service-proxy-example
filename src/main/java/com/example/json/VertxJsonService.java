package com.example.json;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class VertxJsonService implements JsonService {
    @Override
    public void toJson(JsonObject value, Handler<AsyncResult<String>> handler) {
        handler.handle(Future.succeededFuture(Json.encodePrettily(value)));
    }
}
