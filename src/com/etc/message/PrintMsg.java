package com.etc.message;

public class PrintMsg extends BaseMsg {

	private String message;

	public PrintMsg(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void doit() {
		System.out.println(message);
	}

}
