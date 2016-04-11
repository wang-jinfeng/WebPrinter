package com.webprinter.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FileQueue {
//	/**
//	 * 文件GUID
//	 */
//	private String fileGuid;
//	/**
//	 *需要推送的客户端GUID 
//	 */
//	private String clientGuid;
	
	/**
	 * 推送队列
	 */
	Queue<Object> queue = new ArrayBlockingQueue<Object>(10);
}
