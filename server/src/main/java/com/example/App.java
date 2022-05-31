package com.example;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);
        app.ws("/game", ws -> {
            ws.onConnect(ctx -> ctx.send("connected to server"));
            ws.onMessage(ctx -> {
                // GameConfig config = new GameConfig("fred", "guest");
                Example ex = ctx.messageAsClass(Example.class);
                System.out.println(ex.p1Name);
            });
        });
    }
}
