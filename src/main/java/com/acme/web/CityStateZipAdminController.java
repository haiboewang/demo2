package com.acme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.acme.web.domain.CityStateZip;
import com.acme.web.dto.CityStateZipAdminDto;
import com.acme.web.service.CityStateZipService;

@Controller
@RequestMapping("admin/cityStateZipAdmin")
public class CityStateZipAdminController {
	@Autowired
	CityStateZipService cityStateZipService;
	
	private static final String viewName = "cityStateZipAdmin"; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView newForm() {
		ModelAndView modelAndView = new ModelAndView(viewName);
		CityStateZipAdminDto cityStateZipAdminDto = new CityStateZipAdminDto();
		modelAndView.getModel().put("cityStateZipAdminDto", cityStateZipAdminDto);
		cityStateZipAdminDto.setZip("841");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="edit/{action}/id/{id}")
	public RedirectView processEditOrDelete(@PathVariable String action, @PathVariable Long id, 
			@ModelAttribute CityStateZipAdminDto cityStateZipAdminDto/*, RedirectAttributes redirectAttributes*/) {
		if("delete".equalsIgnoreCase(action)) {
			cityStateZipService.delete(id);
			cityStateZipAdminDto.setMessage("Deleted successfully");			
		} else if("edit".equalsIgnoreCase(action)) {
			cityStateZipAdminDto.setMessage("Coming soon.");			
		}
		RedirectView redirectView = new RedirectView("/search", false);
		redirectView.setContextRelative(true);
		//return "forward:search";
		return redirectView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="search")
	public String processSearch(@ModelAttribute CityStateZipAdminDto cityStateZipAdminDto) {
		search(cityStateZipAdminDto);
		return viewName;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute CityStateZipAdminDto dto) {
		dto.setMessage("");
		String action = dto.getAction();
		if("delete".equalsIgnoreCase(action)) {
			cityStateZipService.delete(dto.getId());
			dto.setMessage("Deleted successfully");			
		} else if("edit".equalsIgnoreCase(action)) {
			dto.setMessage("Coming soon.");			
		}
		dto.setAction("");
		search(dto);
		return viewName;
	}
	
	private void search(CityStateZipAdminDto cityStateZipAdminDto) {
		int pageNumber = cityStateZipAdminDto.getPageNumber() - 1;
		if(pageNumber < 0) {
			pageNumber = 0;
		}
		Pageable pageable = new PageRequest(pageNumber, cityStateZipAdminDto.getPageSize());
		Page<CityStateZip> page = cityStateZipService.findCityStateZipByZipCodeLike(cityStateZipAdminDto.getZip(), pageable);
		cityStateZipAdminDto.setCityStateZipList(page.getContent());
		cityStateZipAdminDto.setPageCount(page.getTotalPages());
		cityStateZipAdminDto.setPageNumber(page.getNumber() + 1);
		
	}
}