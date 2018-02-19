/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.reactivex.json;

import java.util.Map;
import io.reactivex.Observable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


@io.vertx.lang.reactivex.RxGen(com.example.json.JsonService.class)
public class JsonService {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonService that = (JsonService) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.reactivex.TypeArg<JsonService> __TYPE_ARG = new io.vertx.lang.reactivex.TypeArg<>(
    obj -> new JsonService((com.example.json.JsonService) obj),
    JsonService::getDelegate
  );

  private final com.example.json.JsonService delegate;
  
  public JsonService(com.example.json.JsonService delegate) {
    this.delegate = delegate;
  }

  public com.example.json.JsonService getDelegate() {
    return delegate;
  }

  public void toJson(JsonObject value, Handler<AsyncResult<String>> handler) { 
    delegate.toJson(value, handler);
  }

  public Single<String> rxToJson(JsonObject value) { 
    return new io.vertx.reactivex.core.impl.AsyncResultSingle<String>(handler -> {
      toJson(value, handler);
    });
  }


  public static  JsonService newInstance(com.example.json.JsonService arg) {
    return arg != null ? new JsonService(arg) : null;
  }
}
