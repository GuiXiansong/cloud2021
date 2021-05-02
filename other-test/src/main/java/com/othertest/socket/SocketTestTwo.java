package com.othertest.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@ServerEndpoint(value = "/websocketTest/{userId}")
public class SocketTestTwo {
    private final static Logger log=LoggerFactory.getLogger(SocketTestTwo.class);
    private static String userId;
    public static Map<String,Session> users=new HashMap<>();

    /**
     * 连接时执行
     * @param userId
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
        this.userId=userId;
        log.debug("新连接：{}",userId);
        System.out.println("onOpen");
        users.put(userId,session);
        session.getBasicRemote().sendText("桂贤松===================");
    }

    /**
     * 关闭时执行
     */
    @OnClose
    public void onClose(){
        log.debug("连接：{} 关闭",this.userId);
    }

    /**
     * 收到消息时执行
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        log.debug("收到用户{}的消息{}",this.userId,message);
        log.info("收到用户{}的消息:{}",this.userId,message);
        System.out.println();
    }

    /**
     * 连接错误时执行
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        log.debug("用户id为:{}的连接发送错误",this.userId);
        error.printStackTrace();
    }
}
