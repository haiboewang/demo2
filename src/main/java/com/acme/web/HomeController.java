package com.acme.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.web.domain.Customer;
import com.acme.web.repository.CustomerRepository;
import com.acme.web.service.CustomRepositoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/*@PersistenceContext
	private EntityManager entityManager;*/
	@Autowired
	CustomRepositoryService repositoryService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Customer customer = findById(6L);
		model.addAttribute("serverTime", formattedDate + "<BR>" + customer.getFirstName() );
		
		return "home";
	}
	
	private Customer findById(Long id) {
		Customer customer = new Customer();
		customer.setFirstName("firstName");
		return customer;
	}
	
}
