package com.example;

import com.example.foo.FooVerticle;
import com.example.json.JsonVerticle;
import io.vertx.core.Future;
import io.vertx.core.Launcher;
import io.vertx.reactivex.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    public static void main(String[] args) {
        Launcher.executeCommand("run", MainVerticle.class.getName());
    }

    @Override
    public void start(Future<Void> startFuture) {
        vertx.rxDeployVerticle(JsonVerticle.class.getName())
                .toCompletable()
                .andThen(vertx.rxDeployVerticle(FooVerticle.class.getName()))
                .toCompletable()
                .subscribe(startFuture::complete, startFuture::fail);
    }

}
