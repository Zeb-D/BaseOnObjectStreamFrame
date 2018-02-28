package com.etc.message;

import java.io.Serializable;
import java.net.Socket;

//服务端与客户端通信的消息
//对象流读写的对象要能够序列化
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
