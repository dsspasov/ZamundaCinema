package com.zamunda.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/halls", method = RequestMethod.GET)
	public String halls(Model model) {

		return "halls";
	}

	@RequestMapping(value = "/prizeTable", method = RequestMethod.GET)
	public String priceTable(Model model) {

		return "edit/prizeTable";
	}

	@RequestMapping(value = "/addPrizeTable", method = RequestMethod.POST)
	public String addPrizeTable(Model model, Object tableData) {

		return "edit/prizeTable";
	}
}
