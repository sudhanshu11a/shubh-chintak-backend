/**
 * 
 */
package org.shubhchintak.web.controller;


import org.shubhchintak.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sudhanshusharma
 *
 */
@Controller
public class PublicController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Public page");
		String path = "http://localhost:8088/images/teams/team1.jpg";
		model.addAttribute("banner1", path);
		// String name = principal.getName();
		// name = employeeService.getEmployeeNameByName(name);
		// modelMap.addAttribute("name", name);

		return "public";
	}

}
