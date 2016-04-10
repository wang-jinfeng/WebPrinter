package com.webprinter.manager;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import com.webprinter.entity.Client;

/**
 * Socket管理 用于管理客户端注册,删除
 * 
 * @author apple
 * 
 */

@Entity
public class SocketManager {
	/**
	 * Client GUID与Socket关联关系
	 */
	private final Map<String, Socket> clientSocket = new HashMap<String, Socket>();

	public Map<String, Socket> getClientSocket() {
		return clientSocket;
	}

	/**
	 * 
	 * @param client
	 *            客户端
	 * @param socket
	 *            socket
	 */
	public void registClient(Client client, Socket socket) {
		clientSocket.put(client.getGuid(), socket);
	}

	public Socket getSocket(String clientGuid) {
		return clientSocket.get(clientGuid);
	}
}