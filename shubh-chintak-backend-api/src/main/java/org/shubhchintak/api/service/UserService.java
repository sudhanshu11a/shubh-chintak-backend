/**
 * 
 */
package org.shubhchintak.api.service;

import org.shubhchintak.common.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author sudhanshusharma
 *
 */
public interface UserService extends UserDetailsService {

	UserDTO getUserByName(String name, long organizationId, long tenantId);
	
}
