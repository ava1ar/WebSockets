package com.mycompany.websockets.server;

import static spark.Spark.init;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;

public class Server {

    public static void main(String[] args) {
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        webSocket("/ws", ServerWebSocketHandler.class);
        init();
    }

}
