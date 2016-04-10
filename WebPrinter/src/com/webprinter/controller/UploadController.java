package com.webprinter.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	@RequestMapping("/oneUpload")
	public String oneUpload(@RequestParam("docfile") MultipartFile docfile,
			HttpServletRequest request) {

		String uploadUrl = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload/";
		String filename = docfile.getOriginalFilename();

		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		System.out.println("文件上传到: " + uploadUrl + filename);

		File targetFile = new File(uploadUrl + filename);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

		try {
			docfile.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "UploadResult";
	}

	@RequestMapping("/moreUpload")
	public String moreUpload(HttpServletRequest request) {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartHttpServletRequest
				.getFileMap();

		String uploadUrl = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload/";
		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		List<String> fileList = new ArrayList<String>();

		for (MultipartFile file : files.values()) {
			File targetFile = new File(uploadUrl + file.getOriginalFilename());
			if (!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					file.transferTo(targetFile);
					fileList.add("http://localhost:8080/DocUpload/upload/"
							+ file.getOriginalFilename());
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		request.setAttribute("files", fileList);

		return "UploadResult";
	}

}
