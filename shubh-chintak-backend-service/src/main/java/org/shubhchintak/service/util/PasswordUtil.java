/**
 * 
 */
package org.shubhchintak.service.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Util for crating password 
 * 
 * @author sudhanshusharma
 *
 */
@Component
public class PasswordUtil {

	public String convertPassword(String password) {
		String encodedPassword = null;
		if (password != null && "".equals(password.trim())) {
			Md5PasswordEncoder encoder = new Md5PasswordEncoder();
			encodedPassword = encoder.encodePassword(password, null);
		} else {
			throw new IllegalArgumentException("Password can not be null or empty");
		}
		return encodedPassword;
	}
}
