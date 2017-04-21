/**
 * 
 */
package org.shubhchintak.api.service;

import java.util.List;

import org.shubhchintak.common.dto.ProjectDTO;
import org.shubhchintak.common.exception.ApiException;

/**
 * @author sudhanshusharma
 *
 */
public interface ProjectService {

	List<ProjectDTO> getAllProjects(long organizationId, long tenantId) throws ApiException;
	
	void saveProject(ProjectDTO projectDTO) throws ApiException;
}
