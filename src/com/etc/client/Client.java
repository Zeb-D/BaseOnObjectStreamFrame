package com.etc.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.etc.message.BaseMsg;
import com.etc.message.server.LoginMsg;

//tcp客户端
public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		start();
	}

	private static Socket socket;

	public static void start() {
		// 定义连接的ip和端口
		try {
			socket = new Socket("127.0.0.1", 8888);
			System.out.println("Client启动");

			// 启动读线程
			new ClientReadThread(socket).start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ObjectOutputStream objOutputStream = new ObjectOutputStream(
		// socket.getOutputStream());
		//
		// // 从控制台读入
		// Scanner scanner = new Scanner(System.in);
		// while (true) {
		// String instr = scanner.next();
		// String password = scanner.next();
		//
		// if ("quit".equals(instr)) {
		// break;
		// }
		//
		// // 新建消息对象
		// LoginMsg msg = new LoginMsg(instr, password);
		//
		// // 向服务端发送对象
		// objOutputStream.writeObject(msg);
		//
		// // 刷新
		// objOutputStream.flush();
		//
		// }

		// 关闭
		// objOutputStream.close();
	}

	// 发送消息
	public static void sendMsg(BaseMsg msg) {
		try {
			ObjectOutputStream objOutputStream = new ObjectOutputStream(
					socket.getOutputStream());
			objOutputStream.writeObject(msg);
			objOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
