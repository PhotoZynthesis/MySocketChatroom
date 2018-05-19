/**
 * �û��࣬ÿ���û�����һ��Socket�������̡߳�
 * �����̷ֱ߳���ӿͻ��˽������ݺ���ͻ��˷������ݡ�
 */
package com.zxy_01;

import java.net.Socket;

public class User {
	
	private Socket s;
	private Thread send;
	private Thread receive;
	private String ip;
	
	public User(Socket s) {
		this.s = s;
		this.send = new Thread(new MsgSendThread(this.s));
		this.receive = new Thread(new MsgReceiveThread(this.s));
		this.ip = this.s.getInetAddress().getHostAddress();
	}
	
	public void connect() {
		this.receive.start();
		this.send.start();
		System.out.println("ϵͳ��Ϣ: " + ip + "�����������ң�");
	}
}
