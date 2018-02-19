package com.example.foo;

import com.example.reactivex.json.JsonService;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.serviceproxy.ServiceProxyBuilder;

public class FooVerticle extends AbstractVerticle {

    private JsonService jsonService;

    @Override
    public void init(Vertx vertx, Context context) {
        jsonService = new JsonService(new ServiceProxyBuilder(vertx)
                .setAddress("json-service")
                .build(com.example.json.JsonService.class));
    }

    @Override
    public void start(Future<Void> startFuture) {
        new FooService(jsonService)
                .execute()
                .doOnSuccess(System.out::println)
                .toCompletable()
                .subscribe(startFuture::complete, startFuture::fail);
    }

}
