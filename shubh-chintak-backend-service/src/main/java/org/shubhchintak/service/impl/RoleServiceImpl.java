/**
 * 
 */
package org.shubhchintak.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shubhchintak.api.service.RoleService;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.common.exception.ApiException;
import org.shubhchintak.persistence.entity.Role;
import org.shubhchintak.persistence.repository.RoleRepository;
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
	
	/* (non-Javadoc)
	 * @see org.shubhchintak.api.service.RoleService#getAllRoles()
	 */
	@Override
	public List<RoleEnum> getAllRolesEnum() throws ApiException {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		List<RoleEnum> roleEnums = new ArrayList<>();
		for(Role role : roles){
			RoleEnum roleEnum = role.getRoleName();
			roleEnums.add(roleEnum);
		}
		return roleEnums;
	}

}
