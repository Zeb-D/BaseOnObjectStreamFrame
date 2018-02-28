package com.etc.client;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.etc.message.BaseMsg;

//tcp客户端读入线程
public class ClientReadThread extends Thread {

	private Socket socket;

	public ClientReadThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// 循环读入
		try {

			// 循环读
			while (true) {
				// 2 bug .java.io.StreamCorruptedException: invalid type code: AC
				// ObjectInputStream读和写时有个头部
				ObjectInputStream objInputStream = new ObjectInputStream(
						socket.getInputStream());
				// 如果客户端关闭会抛出java.io.EOFException
				BaseMsg msg = (BaseMsg) objInputStream.readObject();
				msg.setSocket(socket);
				msg.doit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
