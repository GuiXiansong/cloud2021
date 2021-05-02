package com.othertest.socket;

import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketTest {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sendSocket = new DatagramSocket(9998);
        DatagramSocket receSocket = new DatagramSocket(9999);
    }
}
