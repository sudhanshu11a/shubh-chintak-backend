/**
 * 
 */
package org.shubhchintak.api.service;

import java.util.List;

import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.dto.UserInfoDTO;
import org.shubhchintak.common.exception.ApiException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author sudhanshusharma
 *
 */
@Service
public interface UserService extends UserDetailsService {

	UserDTO getUserByName(final String name, final long organizationId) throws ApiException;

	void createUser(final UserDTO userDTO) throws ApiException;

	List<UserDTO> getAllUsers(final long organizationId) throws ApiException;
	
	List<UserDTO> getAllUsersSortByName(final long organizationId) throws ApiException;
}
