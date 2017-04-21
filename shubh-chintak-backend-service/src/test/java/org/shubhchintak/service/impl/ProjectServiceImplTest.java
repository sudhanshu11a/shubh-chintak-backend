/**
 * 
 */
package org.shubhchintak.service.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.shubhchintak.api.service.ProjectService;
import org.shubhchintak.common.dto.ProjectDTO;

/**
 * @author sudhanshusharma
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectServiceImplTest {
	
	private ProjectService projectService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		projectService = new ProjectServiceImpl();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.shubhchintak.service.impl.ProjectServiceImpl#getAllProjects(long, long)}.
	 */
	@Test
	public final void testGetAllProjectsCheckNUll() {
		//List<ProjectDTO> projectDTOs = projectService.getAllProjects(1, 1);
		//System.out.println(projectDTOs);
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testGetAllProjectsException() {
		
		
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.shubhchintak.service.impl.ProjectServiceImpl#saveProject(org.shubhchintak.common.dto.ProjectDTO)}.
	 */
	@Test
	public final void testSaveProject() {
		//fail("Not yet implemented"); // TODO
	}

}
