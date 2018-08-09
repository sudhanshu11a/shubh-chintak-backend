/**
 * 
 */
package org.shubhchintak.service.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.common.dto.AddressDTO;
import org.shubhchintak.common.dto.ProjectDTO;
import org.shubhchintak.common.dto.RoleDTO;
import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.persistence.entity.Organization;
import org.shubhchintak.persistence.entity.Project;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.persistence.entity.UserDetails;
import org.shubhchintak.persistence.repository.OrganizationRepository;
import org.shubhchintak.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Address addressModelToAddress(AddressDTO dto, long organizationId) {
		Address address = null;
		if (dto != null) {
			if (dto.getId() != null) {
				address = new Address(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), organizationId, dto.getCity().trim());
			} else {
				address = new Address(dto.getCity().trim());
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
				uploadFile = new UploadFile(dto.getFileName().trim(), dto.getPath().trim(), dto.getType().trim());
			}
		}

		return uploadFile;
	}

	public UserDetails userDetailsModelToUserDetails(UserDTO dto, long organizationId) {
		UserDetails userDetails = null;
		if (dto != null) {
			Address address = addressModelToAddress(dto.getAddress(), organizationId);
			UploadFile uploadFile = uploadFileModelToUploadFile(dto.getProfilePhoto(), organizationId);
			if (dto.getId() != null) {
				userDetails = new UserDetails(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), null, null,
						dto.getActive(), organizationId, dto.getFirstName().trim(), dto.getMiddleName().trim(),
						dto.getLastName().trim(), dto.getDob(), dto.getEmailId().trim(), dto.getMobileNumber().trim(),
						address, uploadFile);
			} else {
				userDetails = new UserDetails(dto.getFirstName().trim(), dto.getMiddleName().trim(),
						dto.getLastName().trim(), dto.getDob(), dto.getEmailId().trim(), dto.getMobileNumber().trim(),
						address, uploadFile);
			}
		}
		return userDetails;
	}

	public User userModelToUser(UserDTO dto, long currentUserId, long organizationId) {
		User user = null;
		if (dto != null) {
			// UserDetails conversion
			UserDetails userDetails = userDetailsModelToUserDetails(dto, organizationId);

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

	public Role roleModelToRole(RoleDTO dto) {
		Role role = null;
		if (dto != null) {
			if (dto.getId() != null) {
				role = new Role(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), 0l, dto.getRoleName(), dto.getDescription(), null, null);

			} else {
				role = new Role(dto.getRoleName(), dto.getDescription(), null, null);
			}
		}
		return role;

	}

	public Project projectModelToProject(ProjectDTO dto) {
		Project project = null;
		if (dto != null) {
			UploadFile logoImage = null;
			UploadFile bannerImage = null;
			if (dto.getId() != null) {
				project = new Project(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), 0l, dto.getName(), dto.getDescription(), dto.getHeading(),
						dto.getDisplayDetails(), dto.getStartDate(), dto.getEndDate(), logoImage, bannerImage);
			} else {

				new Project(dto.getName(), dto.getDescription(), dto.getHeading(), dto.getDisplayDetails(),
						dto.getStartDate(), dto.getEndDate(), logoImage, bannerImage);
			}
		}
		return project;
	}

}
