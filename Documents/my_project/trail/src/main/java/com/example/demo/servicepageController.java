package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class servicepageController {
	
	@GetMapping("/webdev")
	public String webdev() {
		return "webdev";
	}
	
	@GetMapping("/mobileApp")
	public String mapp() {
		return "mobileApp";
	}

	
	@GetMapping("/digitalMarketing")
	public String DM() {
		return "digitalmarketing";
	}
	
	@GetMapping("/uiux")
	public String uiux() {
		return "uiux";
	}
	
	
	@GetMapping("/MetaverseMarketing")
	public String MetaverseMarketing() {
		return "MetaverseMarketing";
	}
	
	@GetMapping("/ContentMarketing")
	public String ContentMarketing() {
		return "ContentMarketing";
	}
	
	@GetMapping("/OnlineReputation")
	public String OnlineReputation() {
		return "OnlineReputation";
	}
	
	
	@GetMapping("/CorporateBranding")
	public String CorporateBranding() {
		return "CorporateBranding";
	}
	
	
}
