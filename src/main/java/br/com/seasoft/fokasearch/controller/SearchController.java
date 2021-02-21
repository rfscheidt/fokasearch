package br.com.seasoft.fokasearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.seasoft.fokasearch.entity.Product;
import br.com.seasoft.fokasearch.service.ProductSearchServiceWithRepo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Foka
 *
 */
@RestController
@RequestMapping("/")
@Slf4j
public class SearchController {
	
	@Autowired
	private  ProductSearchServiceWithRepo productSearchService;

	@GetMapping("/products")
	@ResponseBody
	public List<Product> fetchDesc(@RequestParam(value = "q", required = false) String query) {                         
        log.info("searching by Name {}",query);
		List<Product> products = productSearchService.findByDescription(query) ;
	    log.info("products {}",products);
		return products;
	  }
	
	@GetMapping("/suggestions")
	@ResponseBody
	public List<String> fetchDescSuggests(@RequestParam(value = "q", required = false) String query) {                         
        log.info("searching by Description {}",query);
        List<String> suggests = productSearchService.findByDescriptionString(query);
        log.info("descriptions {}",suggests);
        return suggests;
	  }

}