/*
 * ���з���˵�����
 */
package com.zxy.server;

import java.io.IOException;
import java.util.Scanner;

public class ServerLauncher {
	public static void main(String[] args) throws IOException {
		
		System.out.println("--- MySocketServer ---");
		System.out.println("���������֣�1.���������������2.�����ļ������������");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		switch (mode) {
		case 1:
			System.out.println("����������������Ķ˿�(0~65535)��");
			int port = sc.nextInt();
			System.out.println("�����������������...");
			ChatServer server = new ChatServer(port);
			System.out.println("������������ڵ�ַ" + server.getLocalAddress() + "�˿�" + port + "�����������ڵȴ��ͻ��˵�����...");
			server.startServer();
			
		// case 2:
		}

	}
}
