/*
 * ���з���˵�����
 */
package com.zxy_01;

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
				System.out.println("������������Socket������...");
				MessageReceiveServer mrs = new MessageReceiveServer(12345);
				System.out.println("�ɹ�������������������ڵȴ��ͻ��˵�����...");
				mrs.acceptSocket();
				mrs.getMessage();
		//	case 2:
		}

	}
}
