package com.webprinter.manager;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.webprinter.entity.Client;

/**
 * 
 * @author apple
 * 
 */
public class ClientManager {
	private final Map<String, Client> clientMap = new HashMap<String, Client>();

	public ClientManager() {
		// 初始化map,从数据库中读取

	}

	/**
	 * 客户端注册
	 * 
	 * @param client
	 * @param socket
	 * @return
	 */
	public boolean regist(Client client, Socket socket) {
		return false;
	}

	/**
	 * 移除
	 * @param guid
	 * @return
	 */
	public boolean remove(String guid) {
		return false;
	}
}
