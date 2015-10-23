package com.springinaction.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springinaction.web.form.ShowForm;
import com.springinaction.web.form.ShowSearchForm;
import com.springinaction.web.validator.ShowFormValidator;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.SeatingPlan;
import net.springinaction.exercise1.model.Show;
import net.springinaction.exercise1.service.GenreService;
import net.springinaction.exercise1.service.SeatingPlanService;
import net.springinaction.exercise1.service.ShowService;

@Controller
@SessionAttributes("showSearchForm")
@RequestMapping(value = "/shows")
public class ShowController extends BaseController {

	public static Logger log = LoggerFactory.getLogger(GenreController.class);

	@Autowired
	private ShowService showService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private SeatingPlanService seatingPlanService;

	@Autowired
	private ShowFormValidator showFormValidator;
	
	@RequestMapping(value="/" )
	public final String search(@ModelAttribute("showSearchForm") final ShowSearchForm form, final ModelMap modelMap) {
		List<Show> result = new ArrayList<Show>();
		
		if (form.isEmpty()) {
			result = showService.findAll();	
		} else {
			result = showService.searchByNameAndPerformer(form.getSearchName(), null);
		}
		
		modelMap.addAttribute("result", result);
		return "show/show-list";
	}
	
	
	@RequestMapping(value="/create", method = RequestMethod.GET )
	public final String newShowForm(final ModelMap modelMap) {
		List<Genre> genres = genreService.findAll();
		modelMap.addAttribute("genres", genres);
		
		List<SeatingPlan> seatingPlans = seatingPlanService.findAll();
		modelMap.addAttribute("seatingPlans", seatingPlans);
		
		//modelMap.addAttribute("showForm", new ShowForm());
		return "show/show-form";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST )
	public final String saveShowForm(@Valid ShowForm showForm, BindingResult bindingResult, ModelMap modelMap, final RedirectAttributes redirectAttributes) {
		Map<String, String> messages = null;
		if (bindingResult.hasErrors()) {
			messages = addMessage("bg-danger", "show.validation.failed");
			modelMap.addAttribute("messages", messages);
			if (showForm.getId() == null) {
				List<Genre> genres = genreService.findAll();
				modelMap.addAttribute("genres", genres);

				List<SeatingPlan> seatingPlans = seatingPlanService.findAll();
				modelMap.addAttribute("seatingPlans", seatingPlans);

				modelMap.addAttribute("showForm", showForm);
				return "show/show-form";
			} else {
				return "show/show-form";
			}
        }

		Show show = new Show();
		show.setName(showForm.getName());
		show.setGenre(genreService.findById(showForm.getGenreId()));
		show.setSeatingPlan(seatingPlanService.findById(showForm.getSeatingPlanId()));
		Show savedShow = showService.save(show);

		log.info("---> SAVED Genre={}", savedShow);

		messages = addMessage("bg-success", "show.saved.success");
		redirectAttributes.addFlashAttribute("messages", messages);
		return "redirect:/shows/";
	}

//	private String renderShowDetails(final ShowForm form, final ModelMap modelMap) {
//		modelMap.addAttribute("showForm", form);
//		
//		List<Show> shows = showService.findAll;
//		modelMap.addAttribute("shows", shows);
//		return "genre/genre-details";
//	}
	
	@RequestMapping(value="/edit/{showId}", method = RequestMethod.GET )
	public final String newShowForm(@PathVariable Long showId, final ModelMap modelMap) {
		Show show = showService.findById(showId);
		//TODO: convert show to ShowForm
		
		//modelMap.addAttribute("showForm", showForm);
		return "show/show-form";
	}

	// --- model and binder methods -------------------------------------------
	
		@ModelAttribute("showSearchForm")
	    public ShowSearchForm createShowSearchForm() {
	        return new ShowSearchForm();
	    }

		@InitBinder("showForm")
	    private void initShowFormValidator(WebDataBinder binder) {
	        binder.setValidator(showFormValidator);
	    }
}
