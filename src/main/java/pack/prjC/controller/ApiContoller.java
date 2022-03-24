package pack.prjC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.prjC.service.ApiService;

@Controller
public class ApiContoller {
	
	  @Autowired 
	  ApiService service;
	 
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		service.getApi(model);
		
		return "calculate";
	}
}
