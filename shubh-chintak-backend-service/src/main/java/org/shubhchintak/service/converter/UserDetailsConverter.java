/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.persistence.entity.UserDetails;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public final class UserDetailsConverter implements BaseConverter<UserDTO, UserDetails> {

	@Autowired
	private AddressConverter addressConverter;
	
	@Autowired
	private UploadConverter uploadConverter;
	
	@Override
	public UserDTO convertToDTO(UserDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails convertToEntity(UserDTO dto) {
		UserDetails userDetails = null;
		long organizationId = 0l;
		if (dto != null) {
			Address address = addressConverter.convertToEntity(dto.getAddress());
			UploadFile uploadFile = uploadConverter.convertToEntity(dto.getProfilePhoto());
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

}
