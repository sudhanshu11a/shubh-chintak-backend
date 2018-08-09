/**
 * 
 */
package org.shubhchintak.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.shubhchintak.api.service.ProjectService;
import org.shubhchintak.common.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sudhanshusharma
 *
 */

@Controller
@RequestMapping("/welcome")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("user/project/all_project")
	public String getAllProjectList(){
		List<ProjectDTO> projectDTOs = null;
		List<String> projectList = new ArrayList();
		projectDTOs = projectService.getAllProjects(1l);
		for (ProjectDTO projectDTO : projectDTOs) {
			System.out.println(projectDTO.getName());
			projectList.add(projectDTO.getName());
		}
		return projectList.toString();
		
	}

}
