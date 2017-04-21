/**
 * 
 */
package org.shubhchintak.persistence.repository;

import java.util.List;
import java.util.Set;

import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Set<Role> findByRoleName(List<RoleEnum> roles);
	
}
