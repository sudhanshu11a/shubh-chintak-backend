/**
 * 
 */
package org.shubhchintak.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.shubhchintak.api.service.RoleService;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.constant.PageNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sudhanshusharma
 *
 */
@Controller
@RequestMapping(value="/welcome")
public class MenuPageNavigationController {

	   
	@RequestMapping(value="/dashboard.html" , method=RequestMethod.GET)
	public String flatPage(ModelMap modelMap, Principal principal){
		System.out.println("Page : flot.html");
		return PageNameConstants.TILES_DASHBOARD;
	}
	
	
	

}
