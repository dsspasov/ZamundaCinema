package com.zamunda.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zamunda.cinema.model.Film;
import com.zamunda.cinema.model.Hall;
import com.zamunda.cinema.model.Seat;
import com.zamunda.cinema.repository.ReservationRepository;
import com.zamunda.cinema.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	public UserService us;
	@Autowired
	public ReservationRepository reservationRepo;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, int id) {
		reservationRepo.getAllReservationsForProjection(id);
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

	@RequestMapping(value = "/getFilm", method = RequestMethod.GET)
	public String getFilm(Model model, Long filmId) {
		Film film = us.getFilmById(filmId);
		model.addAttribute("film", film);
		return "displayFilm";
	}

	@RequestMapping(value = "/addPrizeTable", method = RequestMethod.POST)
	public String addPrizeTable(Model model, Object tableData) {

		return "edit/prizeTable";
	}
	
	@RequestMapping(value = "/projection", method = RequestMethod.GET)
	public String getHall(Model model){
		List<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
		for(int i = 1; i<= 15; i=i+5){
			ArrayList<Seat> rows = new ArrayList<Seat>();
			rows.add(new Seat(i,  (i/5) + 1, i%5, 1));
			rows.add(new Seat(i+1,(i/5) + 1, i%5, 1));
			rows.add(new Seat(i+2,(i/5) + 1, i%5, 1));
			rows.add(new Seat(i+3,(i/5) + 1, i%5, 2));
			rows.add(new Seat(i+4,(i/5) + 1, i%5, 1));
			seats.add(rows);
		}	
		model.addAttribute("seats", seats);
		return "projection";
	}

	@RequestMapping(value = "/takeSeats", method = RequestMethod.POST)
	public String takeSeats(Model model) {
		return "displayFilm";
	}

}
