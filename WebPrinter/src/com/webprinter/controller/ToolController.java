package com.webprinter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToolController {

	@RequestMapping("/topage")
	public String toPage(@RequestParam String pagename){
		return pagename;
	}
}
