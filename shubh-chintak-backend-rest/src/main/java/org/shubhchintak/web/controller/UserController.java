/**
 * 
 */
package org.shubhchintak.web.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.shubhchintak.api.service.RoleService;
import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.common.exception.ApiException;
import org.shubhchintak.constant.PageNameConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sudhanshusharma
 *
 */

@Controller
@RequestMapping(value = "/welcome")
public class UserController {
	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	// @Autowired
	// private UserSession userSession;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/admin/user/createUser", method = RequestMethod.GET)
	public String createUserPage(ModelMap modelMap, Principal principal) {

		// modelMap.addAttribute("userInfoDTO", new UserInfoDTO());
		modelMap.addAttribute("userDTO", new UserDTO());
		return PageNameConstants.TILES_CREATE_NEW_USER_PAGE;
	}

	@ModelAttribute("allRoles")
	public List<RoleEnum> populateRoles() {
		List<RoleEnum> allRoles = roleService.getAllRolesEnum();
		// List<RoleEnum> allRoleList = new ArrayList<>();
		// allRoleList.addAll(allRoles);
		return allRoles;
	}

	@RequestMapping(value = "/admin/user/createUserSubmit", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("userDTO") UserDTO newUserDTO, BindingResult result,
			 Principal principal) {

		try {
			// business validation
			if (result.hasErrors()) {
				logger.error(result.toString());
				return PageNameConstants.TILES_CREATE_NEW_USER_PAGE;
			}
			// session data
//			UserDTO userPrincipalNOt = (UserDTO) principal;
			//UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//UserPrincipal userPrincipal = (UserPrincipal) principal;
			//UserDTO userPrincipalNOt = (UserDTO) principal;
			// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			// Service call for creating user
			userService.createUser(newUserDTO);
			logger.info("User Created : " + newUserDTO.getUsername());

		} catch (ApiException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return PageNameConstants.TILES_ALL_USERS_LIST_PAGE;

	}

	@RequestMapping(value = "/admin/user/allUsers", method = RequestMethod.GET)
	public String getAllUsers(ModelMap modelMap, Principal principal) {
		List<UserDTO> userDTOs = null;
		try {
			userDTOs = userService.getAllUsers(1l);
			Map<String, String> userList = new HashMap<>();
			for (UserDTO user : userDTOs) {
				userList.put(user.getUsername(), user.getUsername());
			}
			modelMap.addAttribute("allUserList", userList);
			modelMap.addAttribute("userDTO", new UserDTO());
		} catch (ApiException e) {
			logger.error(e.getMessage());
		}
		return PageNameConstants.TILES_ALL_USERS_LIST_PAGE;
	}

	@RequestMapping(value = "/admin/user/user-details", method = RequestMethod.POST)
	@ResponseBody
	public UserDTO getUserDetails(@RequestParam("username") String username, ModelMap modelMap) {
		List<UserDTO> userDTOs = null;
		System.out.println(username);
		/*
		 * try { //userInfoDTOs = (List<UserInfoDTO>)
		 * modelMap.get("allUserList"); userInfoDTOs =
		 * userService.getAllUsers(1l); if (username!=null && userInfoDTOs !=
		 * null && !userInfoDTOs.isEmpty()) { for(UserInfoDTO user:
		 * userInfoDTOs){ if(username.equals(user.getUsername())){
		 * modelMap.addAttribute("userDetails", user); break; } } } } catch
		 * (ApiException e) { logger.error(e.getMessage()); }
		 */
		// userInfoDTOs = (List<UserInfoDTO>) modelMap.get("allUserList");
		userDTOs = userService.getAllUsers(1l);
		return userDTOs.get(0);
	}

	@RequestMapping(value = "/admin/user/allUsers1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDTO createSmartphone(@RequestBody UserDTO userDTO) {
		List<UserDTO> userDTOs = null;
		System.out.println(userDTO);
		userDTOs = userService.getAllUsers(1l);
		return userDTOs.get(0);
	}

	@RequestMapping(value = "/admin/user/allUsers/username", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDTO getUserDetails(@RequestBody String userName) {
		List<UserDTO> userDTOs = null;
		System.out.println(userName);
		userDTOs = userService.getAllUsers(1l);
		return userDTOs.get(0);
	}

}
