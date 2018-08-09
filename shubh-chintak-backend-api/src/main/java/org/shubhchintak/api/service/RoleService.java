/**
 * 
 */
package org.shubhchintak.api.service;

import java.util.List;

import org.shubhchintak.common.dto.RoleDTO;
import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.common.exception.ApiException;

/**
 * @author sudhanshusharma
 *
 */
public interface RoleService {

	List<RoleEnum> getAllRolesEnum() throws ApiException;
	
	void createRole(final RoleDTO roleDTO) throws ApiException;
}
