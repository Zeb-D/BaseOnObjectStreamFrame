package com.etc.message;

import java.io.Serializable;
import java.net.Socket;

//�������ͻ���ͨ�ŵ���Ϣ
//��������д�Ķ���Ҫ�ܹ����л�
public abstract class BaseMsg implements Serializable {

	protected Socket socket;

	public abstract void doit();

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket
	 *            the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}