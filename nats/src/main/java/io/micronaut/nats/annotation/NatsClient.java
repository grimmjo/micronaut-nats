/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.nats.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.micronaut.aop.Introduction;
import io.micronaut.context.annotation.AliasFor;
import io.micronaut.context.annotation.Type;
import io.micronaut.messaging.annotation.MessageProducer;
import io.micronaut.nats.intercept.NatsIntroductionAdvice;
import io.micronaut.retry.annotation.Recoverable;
import jakarta.inject.Scope;
import jakarta.inject.Singleton;

/**
 * An introduction advice that automatically implemnts interfaces and abstract classes and publishes nats messages.
 * @author jgrimm
 * @see NatsIntroductionAdvice
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Scope
@Introduction
@Type(NatsIntroductionAdvice.class)
@Recoverable
@Singleton
@MessageProducer
public @interface NatsClient {

    /**
     * @see NatsConnection#connection()
     * @return The connection to use
     */
    @AliasFor(annotation = NatsConnection.class, member = "connection")
    String connection() default "";

}
