package br.com.seasoft.fokasearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Foka
 *
 */
@Controller
@Slf4j
public class UIController {
	
	@GetMapping("/search")
    public String home(Model model) {
		log.info("Routing to search page");
        
        return "search";
    }
 
}