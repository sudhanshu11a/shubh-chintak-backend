/**
 * 
 */
package org.shubhchintak.service.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.shubhchintak.common.dto.AddressDTO;
import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.entity.UserDetails;
import org.shubhchintak.persistence.repository.RoleRepository;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public class UserConverter implements BaseConverter<UserDTO, User> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsConverter userDetailsConverter; 
	
	@Autowired
	RoleRepository roleRepository;

	
	@Autowired
	private AddressConverter addressConverter;
	
	@Autowired
	private UploadConverter uploadConverter;
	
	
	@Override
	public UserDTO convertToDTO(User entity) {
		UserDTO userDTO = null;
		if (entity != null) {

			Set<Role> roles = entity.getRoles();
			List<RoleEnum> roleEnums = new ArrayList<>();
			for (Role role : roles) {
				RoleEnum roleEnum = role.getRoleName();
				roleEnums.add(roleEnum);
			}
			AddressDTO addressDTO = addressConverter.convertToDTO(entity.getUserDetails().getAddress());
			UploadFileDTO profilePhoto = uploadConverter.convertToDTO(entity.getUserDetails().getProfilePhoto());

			userDTO = new UserDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), entity.getPassword(),
					entity.getUserName(), entity.getAccountNonExpired(), entity.getAccountNonLocked(),
					entity.getCredentialsNonExpired(), entity.getEnabled(), entity.getUserDetails().getFirstName(),
					entity.getUserDetails().getMiddleName(), entity.getUserDetails().getLastName(),
					entity.getUserDetails().getDob(), entity.getUserDetails().getEmailId(),
					entity.getUserDetails().getMobileNumber(), addressDTO, roleEnums, profilePhoto);
		}
		return userDTO;
	}

	@Override
	public User convertToEntity(UserDTO dto) {
		User user = null;
		Long organizationId =0l;
		if (dto != null) {
			// UserDetails conversion
			UserDetails userDetails =  userDetailsConverter.convertToEntity(dto);

			// Password Encoding
			final String encodedPassword = passwordEncoder.encode(dto.getPassword().trim());

			// find all selected roles
			Set<Role> roles = roleRepository.findByRoleName(dto.getRoles());
			if (dto.getId() != null) {
				user = new User(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), organizationId, dto.getUsername().trim(),
						encodedPassword.trim(), roles, userDetails, true, true, true, true);

			} else {
				user = new User(dto.getUsername().trim(), encodedPassword.trim(), roles, userDetails, true, true, true,
						true);
			}

		}
		return user;

	}

	
	
	
}
