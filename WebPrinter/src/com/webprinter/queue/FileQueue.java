package com.webprinter.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FileQueue {
	/**
	 * 文件GUID
	 */
	private String fileGUID;
	/**
	 *需要推送的客户端GUID 
	 */
	private String clientGUID;
	/**
	 * 
	 */
	
	
	Queue<Object> queue = new ArrayBlockingQueue<Object>(10);
}
