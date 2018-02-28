package com.etc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//tcp服务端
public class Server {

	public static void main(String[] args) throws IOException {
		start();
	}

	// 服务器对象
	private static ServerSocket serverSocket;

	// 标识服务器状态
	public static boolean started = false;

	// 记录所有的socket,同步 
	public static List<Socket> allSocket = new ArrayList<Socket>();

	public static void start() {
		// 定义端口
		try {
			serverSocket = new ServerSocket(8888);

			System.out.println("server启动");
			started = true;

			// 开启监听
			while (true) {
				// 阻塞等待客户端接入
				Socket socket = serverSocket.accept();

				//加入socket队列
				allSocket.add(socket);
				
				// 调用服务线程
				new ServiceThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void stop() {
		try {
			serverSocket.close();
			System.out.println("server关闭");
			started = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
