/**
 * �û��࣬ÿ���û�����һ��Socket�������̡߳�
 * �����̷ֱ߳���ӿͻ��˽������ݺ���ͻ��˷������ݡ�
 */
package com.zxy.server;

import java.net.Socket;

public class User {
	
	private ChatServer server;
	
	private Socket s;
	private Thread receive;
	private String ip;
	
	public User(ChatServer server, Socket s) {
		this.server = server;
		this.s = s;
		this.receive = new Thread(new MsgReceiveThread(server, this.s));
		this.ip = this.s.getInetAddress().getHostAddress();
	}
	
	public void connect() {
		this.receive.start();
		this.server.msg("[System]: " + ip + "�����������ң�");
	}
}
