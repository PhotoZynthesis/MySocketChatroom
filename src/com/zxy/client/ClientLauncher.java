/*
 * ���пͻ��˵�����
 */
package com.zxy.client;

import java.util.Scanner;

public class ClientLauncher {
	public static void main(String[] args) {
		
		System.out.println("--- MySocketClient ---");
		System.out.println("���������֣�1.��������ͻ��ˣ�2.�����ļ�����ͻ��ˡ�");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		switch (mode) {
		case 1:
			System.out.println("�����������������IP��ַ��");
			String ip = sc.next();
			System.out.println("����������������Ķ˿�(0~65535)��");
			int port = sc.nextInt();
			System.out.println("�������ӵ����������...");
			ChatClient client = new ChatClient(ip, port);
			client.startClient();
			// ChatServer server = new ChatServer(port);
			
			// server.startServer();
			
		// case 2:
		}
	}
}
