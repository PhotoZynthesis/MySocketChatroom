package com.zxy_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiveServer extends MySocketServer {

	private InputStream is;

	public MessageReceiveServer(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public void acceptSocket() throws IOException {
		this.s = this.ss.accept();
		this.is = this.s.getInputStream();
		System.out.println("�ɹ���������" + this.s.getInetAddress().getHostAddress() + "������");
	}

	public void getMessage() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
		String output;
		while ((output = br.readLine()) != null) {
			if (output.equals("�ټ�")) {
				System.out.println("--- �Ự�ѽ��� ---");
				break;
			}
			System.out.println(this.s.getInetAddress().getHostAddress() + ":" + output);
		}
		this.s.close();
	}
}
