package com.zxy.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	private int port;
	private Socket socket;
	private DatagramSocket ds;
	private Thread sendThread;
	private Thread receiveThread;
	
	public ChatClient(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
			this.ds = new DatagramSocket(port);
		} catch (UnknownHostException e) {
			System.out.println("�������IP��ַ����/�޷����ӵ���������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�����˽�������ʱ����һЩ���⣡");
			e.printStackTrace();
		}
		this.sendThread = new Thread(new MsgSendThread(this.socket));
		this.receiveThread = new Thread(new MsgReceiveThread(this.ds));
	}
	
	public void startClient() {
		this.receiveThread.start();
		this.sendThread.start();
	}
	
	public void closeClient() {
		
	}
}
