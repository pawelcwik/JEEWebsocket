package com.clockworkgnome;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class Echo {
    private Session session;

    @OnOpen
    public void connect(Session session) {
        this.session = session;
    }
    
    @OnClose
    public void close() {
        this.session = null;
        System.out.println("Closed");
    }
    
    @OnMessage
    public void onMessage(String msg) {
        System.out.println("msg = " + msg);
        this.session.getAsyncRemote().sendText("Echo: " + msg);
    }
    
}
