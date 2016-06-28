package com.zamunda.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zamunda.cinema.model.Hall;
import com.zamunda.cinema.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	public UserService us;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/halls", method = RequestMethod.GET)
	public String halls(Model model) {

		return "halls";
	}

	@RequestMapping(value = "/getHalls", method = RequestMethod.GET)
	public String priceTable(Model model) {
		List<Hall> listOfHalls = us.getHalls();
		return "edit/prizeTable";
	}

	@RequestMapping(value = "/addPrizeTable", method = RequestMethod.POST)
	public String addPrizeTable(Model model, Object tableData) {

		return "edit/prizeTable";
	}
}
