package com.skillstorm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticResourceController {

	//handler mapping, used in spring boot as well
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
