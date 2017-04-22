package myapp.library.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(){
		
		//return "home"; ovo je bilo aktuelno, dok su bile JSP strance, nakon toga koristi se 
		return "static/html/index.html";
 	}
}
