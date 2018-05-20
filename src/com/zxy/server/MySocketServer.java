package com.zxy.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;

public abstract class MySocketServer {

	/**
	 * ��������������������ļ����������������һ������ˣ�һ������ip��ַ��һ���˿�
	 */
	public ServerSocket ss;
	public InetAddress localAddress;
	public int port;

	/**
	 * ͨ��ָ���˿���������������
	 * 
	 * @param port
	 * @throws IOException
	 */
	public MySocketServer(int port) throws IOException {
		this.port = port;
		this.ss = new ServerSocket(port);
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while (en.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) en.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				String ip = address.getHostAddress();
				if (ip.startsWith("192.168.1.")) {
					this.localAddress = address;
					return;
				}
				// System.out.println(address.getHostAddress());
			}
		}
		// this.localAddress = InetAddress.getLocalHost();
	}

	/**
	 * ��ȡ�����������ip��ַ
	 * 
	 * @return ���������ڻ�����ip��ַ
	 */
	public String getLocalAddress() {
		return localAddress.getHostAddress();
	}

	/**
	 * ͨ���ַ������ó����������ip��ַ
	 * 
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
