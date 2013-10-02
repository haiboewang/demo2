package com.acme.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.web.domain.CityStateZip;
import com.acme.web.domain.ContactUs;
import com.acme.web.domain.Customer;
import com.acme.web.domain.State;
import com.acme.web.dto.CityStateZipDto;
import com.acme.web.service.CityStateZipService;

@Controller
@RequestMapping("contactUs")
public class ContactUsController {
	@Autowired
	CityStateZipService cityStateZipService;
	
	@ModelAttribute
	@RequestMapping(method=RequestMethod.GET)
	public ContactUs newForm() {
		ContactUs contactUs = new ContactUs();
		contactUs.getCustomer().setZipcode("34211");
		//contactUs.setCustomer(Customer.getDummyCustomer());
		return contactUs;
	}
	
	@ModelAttribute("states")
	public List<String> getSubjectDropDown() {
		List<String> states = new ArrayList<String>();
		states.add("     ");
		return states;
	}
	
	@ModelAttribute("categories")
	public List<String> getCategoryDropDown() {
		List<String> categories = new ArrayList<String>();
		categories.add("     ");
		categories.add("Requst information");
		categories.add("Requst a callback");
		return categories;
	}
	
	@RequestMapping(value="/contactUs", method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute ContactUs contactUs) {
		return "contactUs";
	}
	
	@RequestMapping(value="cityStateLookup/{zip}", method=RequestMethod.GET)
	@ResponseBody
	public CityStateZipDto getcityStateZip(@PathVariable String zip) {
		CityStateZipDto dto = new CityStateZipDto();
		List<CityStateZip> cityStateZipList = cityStateZipService.findCityStateZipByZipCode(zip);
		if(cityStateZipList.isEmpty()) {
			return dto;
		}
		CityStateZip firstCityStateZip = cityStateZipList.get(0);
		dto.setState(new State(firstCityStateZip.getStateName(), firstCityStateZip.getState()));
		List<String> cityList = new ArrayList<>(cityStateZipList.size());
		dto.setCityList(cityList);
		for(CityStateZip cityStateZip : cityStateZipList) {
			cityList.add(cityStateZip.getCity());
		}
		
		return dto;
	}

}
