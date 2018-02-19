package com.example.json;

import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.serviceproxy.ServiceBinder;

public class JsonVerticle extends AbstractVerticle {

    private MessageConsumer<JsonObject> binder;

    @Override
    public void start(Future<Void> startFuture) {
        binder = new ServiceBinder(vertx.getDelegate())
                .setAddress("json-service")
                .register(JsonService.class, new VertxJsonService());
        binder.completionHandler(startFuture);
    }

    @Override
    public void stop(Future<Void> stopFuture) {
        binder.unregister(stopFuture);
    }
}
