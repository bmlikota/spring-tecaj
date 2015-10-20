package com.springinaction.web.controller;

import java.util.Locale;

import net.springinaction.exercise1.service.GenreService;
import net.springinaction.exercise1.service.PerformerService;
import net.springinaction.exercise1.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Sample mvc controller.
 * 
 * @author dmadunic
 *
 */
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

	@Autowired
	private GenreService genreService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private PerformerService performerService;
	
	@RequestMapping(method = RequestMethod.GET)
    public final String  index(final ModelMap p_modelMap, final Locale p_locale) {
		String view = "index";
		Long genresCount = genreService.count();
		Long showsCount = showService.count();
		Long performersCount = performerService.count();

		p_modelMap.addAttribute("genresCount", genresCount);
		p_modelMap.addAttribute("showsCount", showsCount);
		p_modelMap.addAttribute("performersCount", performersCount);
		
		return view;
    }

}
