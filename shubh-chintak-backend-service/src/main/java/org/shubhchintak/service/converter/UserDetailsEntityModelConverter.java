/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.persistence.entity.UserDetails;
import org.shubhchintak.service.converter.base.BaseEntityModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public final class UserDetailsEntityModelConverter implements BaseEntityModelConverter<UserDTO, UserDetails> {

	@Autowired
	private AddressEntityModelConverter addressEntityModelConverter;
	
	@Autowired
	private UploadFileEntityModelConverter uploadFileEntityModelConverter;
	
	@Override
	public UserDTO entityToDTO(UserDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails dtoToEntity(UserDTO dto) {
		UserDetails userDetails = null;
		long organizationId = 0l;
		if (dto != null) {
			Address address = addressEntityModelConverter.dtoToEntity(dto.getAddress());
			UploadFile uploadFile = uploadFileEntityModelConverter.dtoToEntity(dto.getProfilePhoto());
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
