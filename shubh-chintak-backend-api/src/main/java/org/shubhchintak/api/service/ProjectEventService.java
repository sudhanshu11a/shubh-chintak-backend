/**
 * 
 */
package org.shubhchintak.api.service;

import java.util.List;

import org.shubhchintak.common.dto.ProjectEventDTO;
import org.shubhchintak.common.exception.ApiException;

/**
 * @author sudhanshusharma
 *
 */
public interface ProjectEventService {

	List<ProjectEventDTO> getAllProjectEventByProject(long projectId, long organizationId, long tenantId) throws ApiException;
}
