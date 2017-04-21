/**
 * 
 */
package org.shubhchintak.persistence.repository;

import java.util.List;

import org.shubhchintak.persistence.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query("SELECT p FROM Project p WHERE p.organization.id = :organizationId")
	List<Project> getAllProjects(@Param("organizationId") long organizationId);
		
}
