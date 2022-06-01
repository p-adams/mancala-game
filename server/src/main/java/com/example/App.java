package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);
        app.ws("/game", ws -> {
            ws.onConnect(ctx -> ctx.send("connected to server"));
            ws.onMessage(ctx -> {
                GameConfig ex = ctx.messageAsClass(GameConfig.class);
                ctx.send(ex);
            });
        });
    }
}
