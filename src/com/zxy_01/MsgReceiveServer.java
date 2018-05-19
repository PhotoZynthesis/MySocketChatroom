package com.zxy_01;

import java.io.IOException;
import java.net.Socket;

public class MsgReceiveServer extends MySocketServer {

	/**
	 * ͨ��port����ServerSocket������������� ���������ڲ�ʹ��
	 * 
	 * @param port
	 * @throws IOException
	 */
	private MsgReceiveServer(int port) throws IOException {
		super(port);
	}

	/**
	 * �ⲿͨ���˷������������
	 * 
	 * @throws IOException
	 */
	public void startServer() {
		// while (true) {
		// try {
		// Socket s = ss.accept();
		// new Thread(new MsgUserThread(s)).start();
		// } catch (IOException e) {
		// System.out.println("��������¼��һ��ʧ�ܵ�����");
		// e.printStackTrace();
		// }
		// }
		while(true) {
			try {
				Socket s = ss.accept();
				User u = new User(s);
				u.connect();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	// public void acceptSocket() throws IOException {
	// this.s = this.ss.accept();
	// this.is = this.s.getInputStream();
	// System.out.println("�ɹ���������" + this.s.getInetAddress().getHostAddress() +
	// "������");
	// }
	//
	// public void getMessage() throws IOException {
	// BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
	// String output;
	// while ((output = br.readLine()) != null) {
	// if (output.equals("�ټ�")) {
	// System.out.println("--- �Ự�ѽ��� ---");
	// break;
	// }
	// System.out.println(this.s.getInetAddress().getHostAddress() + ":" + output);
	// }
	// this.s.close();
	// }

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
