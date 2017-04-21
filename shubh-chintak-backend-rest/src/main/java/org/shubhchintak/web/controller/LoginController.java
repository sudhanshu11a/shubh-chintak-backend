/**
 * 
 */
package org.shubhchintak.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shubhchintak.constant.PageNameConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sudhanshusharma
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/welcome/home", method = RequestMethod.GET)
	public String login() {
		System.out.println("Welcome");
		// String name = principal.getName();
		// name = employeeService.getEmployeeNameByName(name);
		// modelMap.addAttribute("name", name);
		return PageNameConstants.TILES_DASHBOARD;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("/loginPage");
		return PageNameConstants.SPRING_LOGIN_PAGE;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return PageNameConstants.SPRING_LOGIN_PAGE;
	}

	@RequestMapping(value = "/loginFailure", method = RequestMethod.GET)
	public String loginFailure() {
		System.out.println("loginFailure");
		return PageNameConstants.SPRING_LOGIN_PAGE;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("message", "Sorry " + username + " You don't have privileges to view this page!!!");
		return "403";
	}

}
