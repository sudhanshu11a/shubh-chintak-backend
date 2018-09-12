/**
 * 
 */
package org.shubhchintak.web.restcontroller;

import java.util.List;

import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("api/v1/user")
public class UserRestController {

	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/usersdetails/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable String username) {
		UserDTO userDTO = null;
		try {
			System.out.println(username);
			logger.info("getUserDetails called");
			userDTO = userService.getUserByName(username, 1l);
			logger.info("getUserDetails" + userDTO);
		} catch (Exception e) {
			logger.error("Exception in getUserDetails : ", e);
		}
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/all-users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getUserDetails() {
		List<UserDTO> userDTOs = null;
		userDTOs = userService.getAllUsers(1l);
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}

	public void createUser() {

	}
}
