package com.etc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.etc.message.BaseMsg;

//�����߳�
public class ServiceThread extends Thread {

	private Socket socket;

	public ServiceThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// ��ӡ�ͻ��˵�����
		// ʹ�ö�����
		try {
			// ѭ����
			while (true) {
				// 1 bug .java.io.StreamCorruptedException: invalid type code:
				// AC
				// ObjectInputStream����дʱ�и�ͷ��
				ObjectInputStream objInputStream = new ObjectInputStream(
						socket.getInputStream());
				// ����ͻ��˹رջ��׳�java.io.EOFException
				BaseMsg msg = (BaseMsg) objInputStream.readObject();
				msg.setSocket(socket);
				msg.doit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				//socket�رպ��Ƴ� 
				Server.allSocket.remove(socket);
				
				socket.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}