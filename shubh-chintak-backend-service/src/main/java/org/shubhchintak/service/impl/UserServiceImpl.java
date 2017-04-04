/**
 * 
 */
package org.shubhchintak.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.repository.UserRepository;
import org.shubhchintak.service.convertor.UserDTOConvertor;
import org.shubhchintak.service.convertor.base.BaseConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sudhanshusharma
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER  = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDTO getUserByName(String name, long organizationId, long tenantId) {
		LOGGER.info("GetUserByName service called");
		UserDTO userDTO = null;
		List<User> users = userRepository.findByUserName(name);
		if (users != null && users.isEmpty()) {
			userDTO = new UserDTO();
			BaseConvertor<UserDTO, User> userDTOConvertor = new UserDTOConvertor();
			userDTO = (UserDTO) userDTOConvertor.entityToDTO(users.get(0));
		}
		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.findByUserName(username);
		System.out.println("User trying to login : " + username );
		User user = null;
		List<GrantedAuthority> authorities = null;
		if (users != null && users.isEmpty()) {
			user = users.get(0);
			authorities = buildUserAuthority(user.getRoles());
		}
		return buildUserForAuthentication(user, authorities);

	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getActive(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
