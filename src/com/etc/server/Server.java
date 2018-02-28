package com.etc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//tcp�����
public class Server {

	public static void main(String[] args) throws IOException {
		start();
	}

	// ����������
	private static ServerSocket serverSocket;

	// ��ʶ������״̬
	public static boolean started = false;

	// ��¼���е�socket,ͬ�� 
	public static List<Socket> allSocket = new ArrayList<Socket>();

	public static void start() {
		// ����˿�
		try {
			serverSocket = new ServerSocket(8888);

			System.out.println("server����");
			started = true;

			// ��������
			while (true) {
				// �����ȴ��ͻ��˽���
				Socket socket = serverSocket.accept();

				//����socket����
				allSocket.add(socket);
				
				// ���÷����߳�
				new ServiceThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void stop() {
		try {
			serverSocket.close();
			System.out.println("server�ر�");
			started = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}