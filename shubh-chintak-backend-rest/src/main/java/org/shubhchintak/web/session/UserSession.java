/**
 * 
 */
package org.shubhchintak.web.session;

import java.io.Serializable;

import org.shubhchintak.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
//@Component
//@Scope("session")
public class UserSession implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	//@Autowired
	//private UserService userService;

	private User user;

	public User getCurrentUser() {
		if (user == null) {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return user;
	}
}
