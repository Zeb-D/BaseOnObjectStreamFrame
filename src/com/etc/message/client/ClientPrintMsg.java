package com.etc.message.client;

import javax.swing.JOptionPane;

import com.etc.client.LoginGUI;
import com.etc.message.BaseMsg;

public class ClientPrintMsg extends BaseMsg {

	private boolean successed;

	public ClientPrintMsg(boolean successed) {
		this.successed = successed;
	}

	@Override
	public void doit() {
		if (successed) {
			JOptionPane.showMessageDialog(null, "��½�ɹ�");
		} else {
			JOptionPane.showMessageDialog(null, "��½ʧ��");
		}
	}
}
