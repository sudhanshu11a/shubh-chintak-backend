/**
 * 
 */
package org.shubhchintak.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.common.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author sudhanshusharma
 *
 */
public class UserUtil {

	public static List<GrantedAuthority> buildUserAuthority(List<RoleEnum> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (RoleEnum userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.name()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}
