/**
 * 
 */
package org.shubhchintak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.shubhchintak.api.service.RoleService;
import org.shubhchintak.common.dto.RoleDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.common.exception.ApiException;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.repository.RoleRepository;
import org.shubhchintak.service.converter.ModelToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sudhanshusharma
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelToEntityConverter modelToEntityConverter;
	
	/* (non-Javadoc)
	 * @see org.shubhchintak.api.service.RoleService#getAllRoles()
	 */
	@Override
	public List<RoleEnum> getAllRolesEnum() throws ApiException {
		List<Role> roles = null;
		List<RoleEnum> roleEnums = null;
		try{
			roles = (List<Role>) roleRepository.findAll();
			roleEnums = new ArrayList<>();
			for(Role role : roles){
				RoleEnum roleEnum = role.getRoleName();
				roleEnums.add(roleEnum);
			}
		}catch(Exception e){
			throw new ApiException(e.getMessage(), e);
		}
		return roleEnums;
	}

	@Override
	public void createRole(RoleDTO roleDTO) throws ApiException {
		Role role = null;
		try{
			role = modelToEntityConverter.roleModelToRole(roleDTO);
			roleRepository.saveAndFlush(role);
		}catch(Exception e){
			throw new ApiException(e.getMessage(), e);
		}
	}

}
