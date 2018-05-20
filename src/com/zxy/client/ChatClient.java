package com.zxy.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	
	public boolean flag = false;
	
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
		this.sendThread = new Thread(new MsgSendThread(this, this.socket));
		this.receiveThread = new Thread(new MsgReceiveThread(this, this.ds));
		
	}
	
	public void startClient() {
		
		this.flag = true;
		this.receiveThread.start();
		this.sendThread.start();
		System.out.println("�ɹ����ӵ������������������Կ�ʼ���죡����88���˳����졣");
		
	}
	
	public void closeClient() {
		
		this.flag = false;
		this.receiveThread.interrupt();
		// this.ds.close();
		this.sendThread.interrupt();
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("������������Ͽ����ӣ�");
		
	}
	
}
