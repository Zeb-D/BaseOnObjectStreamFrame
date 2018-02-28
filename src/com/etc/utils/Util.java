package com.etc.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.etc.message.BaseMsg;
import com.etc.server.Server;

public class Util {

	public static void sendMsg(Socket socket, BaseMsg msg) {
		try {
			ObjectOutputStream objOutputStream = new ObjectOutputStream(
					socket.getOutputStream());
			objOutputStream.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendToAllMsg(BaseMsg msg) {
		for (Socket socket : Server.allSocket) {
			try {
				ObjectOutputStream objOutputStream = new ObjectOutputStream(
						socket.getOutputStream());
				objOutputStream.writeObject(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
