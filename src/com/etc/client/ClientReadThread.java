package com.etc.client;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.etc.message.BaseMsg;

//tcp�ͻ��˶����߳�
public class ClientReadThread extends Thread {

	private Socket socket;

	public ClientReadThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// ѭ������
		try {

			// ѭ����
			while (true) {
				// 2 bug .java.io.StreamCorruptedException: invalid type code: AC
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
		}

	}
}