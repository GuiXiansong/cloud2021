package com.othertest.controller;

import com.othertest.pojo.TransformerLossAO;
import com.othertest.socket.SocketTestTwo;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/dingding")
public class DingdingTest {
    @RequestMapping("/dingdingTest")
    public String dingdingTest() {
        return "dingdingTest";
    }

    @PostMapping("/queryDetailsOfCollectionOfElectricityCharges")
    public String getA(@RequestBody TransformerLossAO transformerLossAO) {
        System.out.println("哈哈哈哈哈");
        System.out.println(transformerLossAO);
        return "反悔了";
    }

    private int i=0;
    @GetMapping("/sendMessage")
    public void sendMessage(String userId){
        i++;
        Map<String, Session> users = SocketTestTwo.users;
        Session session = users.get(userId);
        try {
            session.getBasicRemote().sendText("你的userId为："+userId+",您是第"+i+"个");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
