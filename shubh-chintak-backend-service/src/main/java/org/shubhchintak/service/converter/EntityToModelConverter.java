/**
 * 
 */
package org.shubhchintak.service.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.common.dto.AddressDTO;
import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.persistence.entity.Organization;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.persistence.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public class EntityToModelConverter {

	/**
	 * Address model converter
	 * 
	 * @param entity
	 * @param organizationDTO
	 * @return
	 */
	public AddressDTO addressToAddressDTO(Address entity) {
		AddressDTO addressDTO = null;
		if (entity != null) {
			addressDTO = new AddressDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), entity.getCity());
		}

		return addressDTO;
	}

	/**
	 * UploadFile Model Converter
	 * 
	 * @param entity
	 * @param organizationDTO
	 * @return
	 */
	public UploadFileDTO uploadFileToUploadFileDTO(UploadFile entity) {
		UploadFileDTO uploadFileDTO = null;
		if (entity != null) {
			uploadFileDTO = new UploadFileDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), null, entity.getFileName(),
					entity.getPath(), entity.getType());
		}
		return uploadFileDTO;
	}

	/**
	 * Organization Model Converter
	 * 
	 * @param entity
	 * @return
	 */
	public OrganizationDTO organizationToOrganizationDTO(Organization entity) {
		OrganizationDTO organizationDTO = null;
		if (entity != null) {
			organizationDTO = new OrganizationDTO(entity.getId(), entity.getOrganizationName(), entity.getCreatedDate(),
					entity.getCreatedBy(), entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive());
		}

		return organizationDTO;
	}

	/**
	 * User Model Converter
	 * 
	 * @param entity
	 * @param organizationDTO
	 * @return
	 */
	public UserDTO userToUserModel(User entity, OrganizationDTO organizationDTO) {
		UserDTO userDTO = null;
		if (entity != null && organizationDTO != null) {
			Set<Role> roles = entity.getRoles();
			List<RoleEnum> roleEnums = new ArrayList<>();
			for (Role role : roles) {
				RoleEnum roleEnum = role.getRoleName();
				roleEnums.add(roleEnum);
			}
			AddressDTO addressDTO = addressToAddressDTO(entity.getUserDetails().getAddress());
			UploadFileDTO profilePhoto = uploadFileToUploadFileDTO(entity.getUserDetails().getProfilePhoto());

			userDTO = new UserDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(), entity.getModifiedDate(), entity.getModifiedBy(),
				entity.getActive(), entity.getPassword(), entity.getUserName(), entity.getAccountNonExpired(), entity.getAccountNonLocked(),
				entity.getCredentialsNonExpired(), entity.getEnabled(), entity.getUserDetails().getFirstName(),
				entity.getUserDetails().getMiddleName(), entity.getUserDetails().getLastName(),
				entity.getUserDetails().getDob(), entity.getUserDetails().getEmailId(),
				entity.getUserDetails().getMobileNumber(), addressDTO, roleEnums, profilePhoto);
		}
		return userDTO;
	}

	/**
	 * User Entity list to Model list converter
	 * @param entities
	 * @param organizationDTO
	 * @return
	 */
	public List<UserDTO> userListToUserModelList(List<User> entities, OrganizationDTO organizationDTO) {
		List<UserDTO> userDTOList = null;
		if (entities != null && !entities.isEmpty() && organizationDTO != null) {
			userDTOList = new ArrayList<>();
			for (User entity : entities) {
				userDTOList.add(userToUserModel(entity, organizationDTO));
			}
		}
		return userDTOList;
	}

}
