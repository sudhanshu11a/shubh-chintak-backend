/**
 * 
 */
package org.shubhchintak.api.service;

import java.util.List;
import java.util.Set;

import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.common.exception.ApiException;

/**
 * @author sudhanshusharma
 *
 */
public interface RoleService {

	List<RoleEnum> getAllRolesEnum() throws ApiException;
}
