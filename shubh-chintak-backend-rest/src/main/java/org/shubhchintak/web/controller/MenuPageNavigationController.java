/**
 * 
 */
package org.shubhchintak.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sudhanshusharma
 *
 */
@Controller
public class HomePageNavigation {

	@RequestMapping(value="/pages/flot.html" , method=RequestMethod.GET)
	public String flatPage(ModelMap modelMap, Principal principal){
		System.out.println("Page : flot.html");
		return "pages/flot";
	}
}
