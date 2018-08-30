/**
* 
*/
package org.shubhchintak.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.dto.UserPrincipal;
import org.shubhchintak.common.exception.ApiException;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.repository.UserRepository;
import org.shubhchintak.service.converter.EntityToModelConverter;
import org.shubhchintak.service.converter.ModelToEntityConverter;
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
	private UserRepository userRepository;

	@Override
	public UserDTO getUserByName(String name, long organizationId) throws ApiException {
		UserDTO userDTO = null;
		List<User> users = null;
		try {
			users = userRepository.findByUserName(name);
			if (users != null && !users.isEmpty()) {
				// OrganizationDTO organizationDTO = entityToModelConverter
				// .organizationToOrganizationDTO(users.get(0).getOrganization());
				userDTO = entityToModelConverter.userToUserModel(users.get(0));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApiException(e.getMessage(), e);
		} finally {
			users = null;
		}

		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = null;
		User user = null;
		UserDetails userDetails;
		try {
			users = userRepository.findByUserName(username);
			if (users == null || users.isEmpty()) {
				throw new UsernameNotFoundException(username);
			}
			user = users.get(0);
			OrganizationDTO organizationDTO = entityToModelConverter
					.organizationToOrganizationDTO(user.getOrganization());
			UserDTO userDTO = entityToModelConverter.userToUserModel(user);
			userDetails = new UserPrincipal(userDTO, organizationDTO);
		} finally {
			user = null;
			users = null;
		}
		return userDetails;
	}

	@Override
	public void createUser(UserDTO userDTO) throws ApiException {

		User user = null;
		if (userDTO != null) {
			try {
				// current user information
				UserPrincipal currentUserPrincipal = (UserPrincipal) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal();

				// Converter to user entity
				user = modelToEntityConverter.userModelToUser(userDTO, currentUserPrincipal.getCurrentUserId(),
						currentUserPrincipal.getOrganizationId());
				// call repository for saving user
				userRepository.saveAndFlush(user);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new ApiException(e.getMessage(), e);
			}
		} else {
			logger.error(" createUser service, IllLegalArgumentException : UserDTO null is not allowed");
			throw new ApiException("IllLegalArgumentException : null is not allowed");
		}

	}

	@Override
	public List<UserDTO> getAllUsers(long organizationId) throws ApiException {
		// List<UserDTO> userInfoDTOList = null;
		List<UserDTO> userDTOList = null;
		List<User> users = null;
		// OrganizationDTO organizationDTO = null;
		try {
			users = userRepository.getAllUsersList(organizationId);
			if (users != null && !users.isEmpty()) {
				// organizationDTO =
				// entityToModelConverter.organizationToOrganizationDTO(users.get(0).getOrganization());
				userDTOList = entityToModelConverter.userListToUserModelList(users);
				// userInfoDTOList =
				// modelToModelConverter.userDTOListToUserInfoDTOList(userDTOList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApiException(e.getMessage(), e);
		}
		return userDTOList;
	}

	@Override
	public List<UserDTO> getAllUsersSortByName(long organizationId) throws ApiException {
		List<UserDTO> userDTOList = null;
		List<User> users = null;
		try {
			users = userRepository.getAllUsersList(organizationId);
			if (users != null && !users.isEmpty()) {
				userDTOList = entityToModelConverter.userListToUserModelList(users);
			}
			// Sorting using Lambda
			// userDTOList.sort((userDTO1, userDTO2) ->
			// userDTO1.getFirstName().compareTo(userDTO1.getFirstName()));
			Collections.sort(userDTOList, Comparator.comparing(UserDTO::getFirstName));

			// userDTOList.stream().forEach(System.out::println);
			// userDTOList.sort((userDTO1, userDTO2) ->
			// userDTO1.getFirstName().compareTo(userDTO1.getFirstName()));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApiException(e.getMessage(), e);
		}
		return userDTOList;
	}

}
