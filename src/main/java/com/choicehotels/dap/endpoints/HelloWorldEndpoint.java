package com.choicehotels.dap.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@Endpoint(id = "helloworld")
public class HelloWorldEndpoint {
    @ReadOperation
    public Message read() {
        return new Message("Hello world");
    }

    @Getter
    @RequiredArgsConstructor
    public static class Message {
        private final String message;
    }
    

}