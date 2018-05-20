/*
 * ���������
 */
package com.zxy.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatServer extends MySocketServer {

	private DatagramSocket ds;
	private InetAddress broadcastIp;

	/**
	 * ͨ��port����ServerSocket������������� ���������ڲ�ʹ��
	 * 
	 * @param port
	 * @throws IOException
	 */
	public ChatServer(int port) throws IOException {
		super(port);
	}

	/**
	 * �ⲿͨ���˷������������
	 * 
	 * @throws IOException
	 */
	public void startServer() {

		try {
			this.ds = new DatagramSocket();
			this.broadcastIp = InetAddress.getByName("192.168.1.255");
		} catch (UnknownHostException e1) {
			System.out.println("�㲥��ַ����ʧ��");
			e1.printStackTrace();
		} catch (SocketException e2) {
			e2.printStackTrace();
		}

		while (true) {
			try {
				Socket s = ss.accept();
				User u = new User(this, s);
				u.connect();
			} catch (IOException e3) {
				System.out.println("[server]: ��������¼��һ��ʧ�ܵ�����");
				e3.printStackTrace();
			}
		}
		
	}

	/**
	 * ����Ҫ��ʾ�ڷ���˿���̨����Ϣ����ʾ��Ϣ�ڷ���˿���̨����UDP�㲥
	 * 
	 * @param s
	 */
	public void msg(String s) {

		System.out.println(s);
		byte[] bys = s.getBytes();
		DatagramPacket packet = new DatagramPacket(bys, bys.length, broadcastIp, this.port);
		try {
			this.ds.send(packet);
		} catch (IOException e) {
			System.out.println("�㲥��Ϣʧ��");
			e.printStackTrace();
		}

	}

	/**
	 * �ⲿͨ���˷����رշ����
	 */
	@Override
	public void shutDown() {

		try {
			this.ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
