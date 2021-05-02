package com.guixiansong.one;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestOne {
    public static void main(String[] args) {
/*        for (int i = 0; i < 100; i++) {
            int j=100+1000;
        }
        System.out.println("start");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("stop");*/

        String str = "[{'columnId':5,'columnName':'人文历史'},{'columnId':2,'columnName':'商业视野'}]";
        String json = "{'columnId':5,'columnName':'人文历史'}";
//        String json = "{"code":0,\"message\":\"没有查询到数据\",\"data\":null,\"taskId\":\"0-bb03193f-ed1f-4d32-8351-6538d329b26e\",\"time\":\"2017-09-2210:11:30\"}";

        Man man = new Man();
        man.setName("哈哈哈哈");
        man.setAge(22);

        String s = JSON.toJSONString(man);
        System.out.println("toJsonString()方法：s=" + s);

        JSONObject obj = JSONObject.parseObject(s);
        System.out.println(obj.getString("name"));
//        Integer code = obj.getInteger("code");
//        String message = obj.getString("message");
//        String taskId = obj.getString("taskId");

//        System.out.println("code:" + code + ", message:" + message + ", taskId:" + taskId);
    }
}
