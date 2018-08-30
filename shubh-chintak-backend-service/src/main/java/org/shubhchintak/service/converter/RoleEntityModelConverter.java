/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.RoleDTO;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.service.converter.base.BaseEntityModelConverter;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public final class RoleEntityModelConverter implements BaseEntityModelConverter<RoleDTO, Role> {

	@Override
	public RoleDTO entityToDTO(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role dtoToEntity(RoleDTO dto) {
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

}
