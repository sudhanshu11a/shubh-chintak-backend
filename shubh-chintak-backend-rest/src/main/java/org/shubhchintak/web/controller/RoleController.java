/**
 * 
 */
package org.shubhchintak.web.controller;

import java.util.List;

import org.shubhchintak.api.service.RoleService;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.constant.PageNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sudhanshusharma
 *
 */
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/admin/role/all_roles" , method = RequestMethod.GET)
	public String getAllRoles(Model model){
		List<RoleEnum> roles = roleService.getAllRolesEnum();
		model.addAttribute("allRoles", roles);
		return PageNameConstants.TILES_ALL_ROLE_LIST_PAGE;
	}
	
	
	@RequestMapping(value = "/admin/role/create_new_role", method = RequestMethod.POST)
	public String createNewRole(Model model){
		return null;
	}
}
