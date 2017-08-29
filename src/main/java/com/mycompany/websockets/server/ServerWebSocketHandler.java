package com.mycompany.websockets.server;

import java.nio.ByteBuffer;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ServerWebSocketHandler {

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        System.out.println("onConnect");
        user.getRemote().sendString("Hi string from server!");
        user.getRemote().sendBytes(ByteBuffer.wrap("Hi bytes from server!".getBytes()));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println("Session closed (statusCode=" + statusCode + ", reason=" + reason + ")");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        System.out.println("Received string message from user: " + message);
    }

    @OnWebSocketMessage
    public void onMessage(Session user, byte buf[], int offset, int length) {
        System.out.println("Received bytes message from user: " + new String(buf));
    }
}
