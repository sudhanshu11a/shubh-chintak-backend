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

	List<ProjectDTO> getAllProjects(long organizationId) throws ApiException;
	
	void saveProject(ProjectDTO projectDTO) throws ApiException;
}
