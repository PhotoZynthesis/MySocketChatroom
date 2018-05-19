package com.zxy.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public abstract class MySocketServer {
	
	/**
	 * ��������������������ļ����������������һ������ˣ�һ������ip��ַ��һ���˿�
	 */
	ServerSocket ss;
	InetAddress localAddress;
	int port;
	
	/**
	 * ͨ��ָ���˿���������������
	 * @param port
	 * @throws IOException
	 */
	public MySocketServer(int port) throws IOException {
		this.port = port;
		this.ss = new ServerSocket(port);
	}

	/**
	 * ��ȡ�����������ip��ַ
	 * @return ���������ڻ�����ip��ַ
	 */
	public String getLocalAddress() {
		return localAddress.getHostAddress();
	}

	/**
	 * ͨ���ַ������ó����������ip��ַ
	 * @param ip
	 * @throws UnknownHostException
	 */
	public void setLocalAddress(String ip) throws UnknownHostException {
		this.localAddress = InetAddress.getByName(ip);
	}

	/**
	 * �������������
	 */
	public abstract void startServer();
	
	/**
	 * �رճ��������
	 */
	public abstract void shutDown();
	
}
