package com.springinaction.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.SeatingPlan;
import net.springinaction.exercise1.model.Show;
import net.springinaction.exercise1.service.GenreService;
import net.springinaction.exercise1.service.SeatingPlanService;
import net.springinaction.exercise1.service.ShowService;

@Controller
@RequestMapping(value = "/shows")
public class ShowController extends BaseController {

	@Autowired
	private ShowService showService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private SeatingPlanService seatingPlanService;
	
	
	@RequestMapping(value="/" )
	public final String search(final ModelMap modelMap) {
		List<Show> result = new ArrayList<Show>();
		
		//TODO: finish me???
		
		modelMap.addAttribute("result", result);
		return "show/show-list";
	}
	
	
	@RequestMapping(value="/create", method = RequestMethod.GET )
	public final String newShowForm(final ModelMap modelMap) {
		List<Genre> genres = genreService.findAll();
		modelMap.addAttribute("genres", genres);
		
		List<SeatingPlan> seatingPlans = seatingPlanService.findAll();
		modelMap.addAttribute("seatingPlans", seatingPlans);
		
		// TODO: finish me
		
		//modelMap.addAttribute("showForm", new ShowForm());
		return "show/show-form";
	}
	
	@RequestMapping(value="/edit/{showId}", method = RequestMethod.GET )
	public final String newShowForm(@PathVariable Long showId, final ModelMap modelMap) {
		Show show = showService.findById(showId);
		//TODO: convert show to ShowForm
		
		//modelMap.addAttribute("showForm", showForm);
		return "show/show-form";
	}
}
