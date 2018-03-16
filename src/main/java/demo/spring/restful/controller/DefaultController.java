package demo.spring.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.spring.restful.bean.User;
import demo.spring.restful.service.UserService;

@Controller
@RequestMapping("/demo")
public class DefaultController {
	
	@Autowired
	private UserService userService;
	
	// Need to set aside jsp in the /main/webapp//WEB-INF/jsp/*.jsp
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Index(Model mv) {
		mv.addAttribute("message", "Hello Demo");
		return "demo";
	}

	// http://localhost:port/demo/param?id=User.
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String queryUserIdParam(@RequestParam(value = "id") int Id, Model mv) {
		String msg = "Hello User " + String.valueOf(Id);
		mv.addAttribute("message", msg);
		return "demo";
	}
}
