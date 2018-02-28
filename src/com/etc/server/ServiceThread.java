package com.etc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.etc.message.BaseMsg;

//服务线程
public class ServiceThread extends Thread {

	private Socket socket;

	public ServiceThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// 打印客户端的输入
		// 使用对象流
		try {
			// 循环读
			while (true) {
				// 1 bug .java.io.StreamCorruptedException: invalid type code:
				// AC
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
			try {
				//socket关闭后移除 
				Server.allSocket.remove(socket);
				
				socket.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
