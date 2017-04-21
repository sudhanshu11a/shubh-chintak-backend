/**
 * 
 */
package org.shubhchintak.service.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.common.dto.AddressDTO;
import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.persistence.entity.Organization;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.entity.UserDetails;
import org.shubhchintak.persistence.repository.OrganizationRepository;
import org.shubhchintak.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public class ModelToEntityConverter {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	public Address addressModelToAddress(AddressDTO dto, long organizationId) {
		Address address = null;
		if (dto != null) {
			if (dto.getId() != null) {
				address = new Address(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), organizationId, dto.getCity());
			} else {
				address = new Address(dto.getCity());
			}

		}
		return address;
	}

	public UploadFile uploadFileModelToUploadFile(UploadFileDTO dto, long organizationId) {
		UploadFile uploadFile = null;
		if (dto != null) {
			if (dto.getId() != null) {
				uploadFile = new UploadFile(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(),
						dto.getModifiedDate(), dto.getModifiedBy(), dto.getActive(), organizationId, dto.getFileName(),
						dto.getPath(), dto.getType());
			} else {
				uploadFile = new UploadFile(dto.getFileName(), dto.getPath(), dto.getType());
			}

		}

		return uploadFile;
	}

	public UserDetails UserDetailsModelToUserDetails(UserDTO dto, long organizationId) {
		UserDetails userDetails = null;
		if (dto != null) {
			Address address = addressModelToAddress(dto.getAddress(), organizationId);
			UploadFile uploadFile = uploadFileModelToUploadFile(dto.getProfilePhoto(), organizationId);
			if (dto.getId() != null) {
				userDetails = new UserDetails(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), null, null,
						dto.getActive(), organizationId, dto.getFirstName(), dto.getMiddleName(), dto.getLastName(),
						dto.getDob(), dto.getEmailId(), dto.getMobileNumber(), address, uploadFile);
			} else {
				userDetails = new UserDetails(dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), dto.getDob(),
						dto.getEmailId(), dto.getMobileNumber(), address, uploadFile);
			}
		}
		return userDetails;
	}

	public User UserModelToUser(UserDTO dto, long currentUserId, long organizationId) {
		User user = null;
		if (dto != null) {
			// UserDetails conversion
			UserDetails userDetails = UserDetailsModelToUserDetails(dto, organizationId);
			// find all selected roles
			Set<Role> roles = roleRepository.findByRoleName(dto.getRoles());
			if (dto.getId() != null) {
				user = new User(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), organizationId, dto.getUsername(), dto.getPassword(),
						roles, userDetails, true, true, true, true);

			} else {
				user = new User(dto.getUsername(), dto.getPassword(), roles, userDetails, true, true, true, true);
			}

		}
		return user;
	}

}
