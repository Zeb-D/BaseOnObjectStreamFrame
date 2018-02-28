package com.etc.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.etc.message.BaseMsg;
import com.etc.message.server.LoginMsg;

//tcp�ͻ���
public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		start();
	}

	private static Socket socket;

	public static void start() {
		// �������ӵ�ip�Ͷ˿�
		try {
			socket = new Socket("127.0.0.1", 8888);
			System.out.println("Client����");

			// �������߳�
			new ClientReadThread(socket).start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ObjectOutputStream objOutputStream = new ObjectOutputStream(
		// socket.getOutputStream());
		//
		// // �ӿ���̨����
		// Scanner scanner = new Scanner(System.in);
		// while (true) {
		// String instr = scanner.next();
		// String password = scanner.next();
		//
		// if ("quit".equals(instr)) {
		// break;
		// }
		//
		// // �½���Ϣ����
		// LoginMsg msg = new LoginMsg(instr, password);
		//
		// // �����˷��Ͷ���
		// objOutputStream.writeObject(msg);
		//
		// // ˢ��
		// objOutputStream.flush();
		//
		// }

		// �ر�
		// objOutputStream.close();
	}

	// ������Ϣ
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