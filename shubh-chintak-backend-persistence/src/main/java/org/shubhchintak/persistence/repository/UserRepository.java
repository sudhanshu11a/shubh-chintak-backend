/**
 * 
 */
package org.shubhchintak.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.shubhchintak.persistence.entity.User;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserName(String userName);

	@Query("SELECT user FROM User user WHERE user.organization.id = :organizationId")
	List<User> getAllUsersList(@Param("organizationId") Long organizationId);

}
