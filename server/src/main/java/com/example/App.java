package com.example;

import com.example.protocol.Message;
import com.example.protocol.MessageProtocol;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);
        app.ws("/game", ws -> {
            ws.onConnect(ctx -> {
                System.out.println("connected to server");
            });
            ws.onMessage(ctx -> {
                MessageProtocol msg = ctx.messageAsClass(MessageProtocol.class);
                switch (msg.getMessageType()) {
                    case "START_GAME":
                        GameCoordinator mancalaGame = new GameCoordinator(msg.getData());
                        Message message = new Message("START_GAME", mancalaGame);
                        ctx.send(message);
                        break;

                    default:
                        break;
                }

            });
        });
    }
}
