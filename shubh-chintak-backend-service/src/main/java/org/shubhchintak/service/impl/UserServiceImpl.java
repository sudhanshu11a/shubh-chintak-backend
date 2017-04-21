	/**
 * 
 */
package org.shubhchintak.service.impl;

import java.util.List;

import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.dto.UserInfoDTO;
import org.shubhchintak.common.dto.UserPrincipal;
import org.shubhchintak.common.exception.ApiException;
import org.shubhchintak.persistence.entity.Organization;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.repository.OrganizationRepository;
import org.shubhchintak.persistence.repository.UserRepository;
import org.shubhchintak.service.converter.EntityToModelConverter;
import org.shubhchintak.service.converter.ModelToEntityConverter;
import org.shubhchintak.service.converter.ModelToModelConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ModelToEntityConverter modelToEntityConverter;

	@Autowired
	private EntityToModelConverter entityToModelConverter;

	@Autowired
	private ModelToModelConverter modelToModelConverter;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public UserDTO getUserByName(String name, long organizationId) {
		UserDTO userDTO = null;
		List<User> users = userRepository.findByUserName(name);

		if (users != null && !users.isEmpty()) {
			OrganizationDTO organizationDTO = entityToModelConverter
					.organizationToOrganizationDTO(users.get(0).getOrganization());
			userDTO = entityToModelConverter.userToUserModel(users.get(0), organizationDTO);
		}
		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.findByUserName(username);
		System.out.println("User trying to login : " + username);
		User user = null;
		// List<GrantedAuthority> authorities = null;
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		user = users.get(0);
		OrganizationDTO organizationDTO = entityToModelConverter.organizationToOrganizationDTO(user.getOrganization());
		UserDTO userDTO = entityToModelConverter.userToUserModel(user, organizationDTO);
		return new UserPrincipal(userDTO, organizationDTO);
	}

	@Override
	public void createUser(UserDTO userDTO) throws ApiException {

		User user = null;
		if (userDTO != null) {
			try {
				//current user information
				UserPrincipal currentUserPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
				// Converter to user entity
				user = modelToEntityConverter.UserModelToUser(userDTO, currentUserPrincipal.getCurrentUserId(), currentUserPrincipal.getOrganizationId());
				// call repository for saving user
				userRepository.saveAndFlush(user);
			} catch (Exception e) {
				throw new ApiException(e.getMessage(), e);
			}
		} else {
			throw new ApiException("IllLegalArgumentException : null is not allowed");
		}

	}

	

	@Override
	public List<UserDTO> getAllUsers(long organizationId) throws ApiException {
		//List<UserDTO> userInfoDTOList = null;
		List<UserDTO> userDTOList = null;
		List<User> users = null;
		OrganizationDTO organizationDTO = null;
		try {
			users = userRepository.getAllUsersList(organizationId);
			if (users != null && !users.isEmpty()) {
				organizationDTO = entityToModelConverter.organizationToOrganizationDTO(users.get(0).getOrganization());
				userDTOList = entityToModelConverter.userListToUserModelList(users, organizationDTO);
				//userInfoDTOList = modelToModelConverter.userDTOListToUserInfoDTOList(userDTOList);
			}
		} catch (Exception e) {
			throw new ApiException(e.getMessage(), e);
		}
		return userDTOList;
	}

	
}
