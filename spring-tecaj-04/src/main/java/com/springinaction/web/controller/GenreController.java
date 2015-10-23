package com.springinaction.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.aspectj.weaver.tools.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springinaction.web.form.GenreForm;
import com.springinaction.web.form.GenreSearchForm;
import com.springinaction.web.validator.GenreFormValidator;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.Show;
import net.springinaction.exercise1.service.GenreService;
import net.springinaction.exercise1.service.ShowService;

@Controller
@SessionAttributes("genreSearchForm")
@RequestMapping(value = "/genres")
public class GenreController extends BaseController {
	public static Logger log = LoggerFactory.getLogger(GenreController.class);
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private GenreFormValidator genreFormValidator;
	
	@RequestMapping(value="/" )
	public final String search(@ModelAttribute("genreSearchForm") final GenreSearchForm form, final ModelMap modelMap) {
		List<Genre> result = null;
		if (form.isEmpty()) {
			result = genreService.findAll();	
		} else {
			result = genreService.searchByName(form.getSearchName());
		}
		modelMap.addAttribute("result", result);
		
		return "genre/genre-list";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET )
	public final String genreDetails(@PathVariable(value = "id") Long genreId, final ModelMap modelMap) {
		Genre genre = genreService.findById(genreId);
		//TODO: handle if genre is null
		return renderGenreDetails(new GenreForm(genre), modelMap);
	}
	
	private String renderGenreDetails(final GenreForm form, final ModelMap modelMap) {
		modelMap.addAttribute("genreForm", form);
		
		List<Show> shows = showService.findByGenreId(form.getGenreId());
		modelMap.addAttribute("shows", shows);
		return "genre/genre-details";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET )
	public final String newGenreForm(final ModelMap modelMap) {
		
		modelMap.addAttribute("genreForm", new GenreForm());
		return "genre/genre-new";
	}

	//zelim da se validira genreForm prije ulaska u handler, rezultati validacije zavrse u bindingResult
	@RequestMapping(value="/save", method = RequestMethod.POST )
	public final String saveGenre(@Valid GenreForm genreForm, BindingResult bindingResult, ModelMap modelMap, final RedirectAttributes redirectAttributes) {
		Map<String, String> messages = null;
		if (bindingResult.hasErrors()) {
			messages = addMessage("bg-danger", "genre.validation.failed");
			modelMap.addAttribute("messages", messages);
			if (genreForm.getGenreId() == null) {
				modelMap.addAttribute("genreForm", genreForm);
				return "genre/genre-new";
			} else {
				return renderGenreDetails(genreForm, modelMap);
			}
        }
		
		Genre genre = new Genre();
		genre.setName(genreForm.getName());
		genre.setId(genreForm.getGenreId());
		Genre savedGenre = genreService.save(genre);
		
		log.info("---> SAVED Genre={}", savedGenre);
		
		messages = addMessage("bg-success", "genre.saved.success");
		modelMap.addAttribute("messages", messages);
		return renderGenreDetails(new GenreForm(savedGenre), modelMap);
	}

	//post-get pattern
	@RequestMapping(value="/delete/{genreId}", method = RequestMethod.GET )
	public final String delete(@PathVariable Long genreId, final ModelMap modelMap, final RedirectAttributes redirectAttributes) {
		Map<String, String> messages = null;
		try {
			genreService.delete(genreId);
			messages = addMessage("bg-success", "genre.delete.success");
		} catch (DataIntegrityViolationException ex) {
			log.debug("Failed to delete genre some some show records depend on it.");
			messages = addMessage("bg-danger", "genre.delete.failed.unique-constraint-violation");
		}
		redirectAttributes.addFlashAttribute("messages", messages);
		return "redirect:/genres/";
	}
	
	// --- model and binder methods -------------------------------------------
	
	@ModelAttribute("genreSearchForm")
    public GenreSearchForm createGenreSearchForm() {
        return new GenreSearchForm();
    }
	
	@InitBinder("genreForm")
    private void initGenreFormValidator(WebDataBinder binder) {
        binder.setValidator(genreFormValidator);
    }
	
}
