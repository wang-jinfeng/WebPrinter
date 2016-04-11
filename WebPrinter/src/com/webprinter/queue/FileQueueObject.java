package com.webprinter.queue;

import com.webprinter.entity.Client;

public class FileQueueObject {
	/**
	 * 文件GUID
	 */
	private String fileGuid;
	
	/**
	 * 需要推送的客户端GUID
	 */
	private String clientGuid;
	
	public String getFileGuid() {
		return fileGuid;
	}
	public void setFileGuid(String fileGuid) {
		this.fileGuid = fileGuid;
	}
	public String getClientGuid() {
		return clientGuid;
	}
	public void setClientGuid(String clientGuid) {
		this.clientGuid = clientGuid;
	}
	
	
	public Client getClient(){
		return null;
	}
	
}
