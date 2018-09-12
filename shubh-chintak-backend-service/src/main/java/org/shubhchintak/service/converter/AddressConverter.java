/**
 * 
 */
package org.shubhchintak.service.converter;

import java.util.List;

import org.shubhchintak.common.dto.AddressDTO;
import org.shubhchintak.persistence.entity.Address;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public class AddressConverter implements BaseConverter<AddressDTO, Address>{

	@Override
	public AddressDTO convertToDTO(Address entity) {
		AddressDTO addressDTO = null;
		if (entity != null) {
			addressDTO = new AddressDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), entity.getCity());
		}
		return addressDTO;
	}

	@Override
	public Address convertToEntity(AddressDTO dto) {
		Address address = null;
		Long organizationId = 0l;
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

}
