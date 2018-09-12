/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.persistence.entity.Organization;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public class OrganizationConverter implements BaseConverter<OrganizationDTO, Organization>{

	@Override
	public OrganizationDTO convertToDTO(Organization entity) {
		OrganizationDTO organizationDTO = null;
		if (entity != null) {
			organizationDTO = new OrganizationDTO(entity.getId(), entity.getOrganizationName(), entity.getCreatedDate(),
					entity.getCreatedBy(), entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive());
		}

		return organizationDTO;
	}

	@Override
	public Organization convertToEntity(OrganizationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
