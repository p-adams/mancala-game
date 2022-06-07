package com.example;

import com.example.protocol.Message;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);
        app.ws("/game", ws -> {
            ws.onConnect(ctx -> {
                System.out.println("connected to server");
            });
            ws.onMessage(ctx -> {
                Game mancalaGame = new Game(ctx.messageAsClass(GameConfig.class));
                Message message = new Message("START_GAME", mancalaGame);
                ctx.send(message);
            });
        });
    }
}
