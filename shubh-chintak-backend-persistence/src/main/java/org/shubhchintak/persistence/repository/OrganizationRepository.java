/**
 * 
 */
package org.shubhchintak.persistence.repository;

import org.shubhchintak.persistence.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	@Query("SELECT o FROM Organization o WHERE o.id= :id")
	Organization findByOrganizationId(@Param("id") Long id);
	
	Organization findById(final long id);
	
}
