/**
 * 
 */
package org.shubhchintak.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.shubhchintak.persistence.entity.User;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUserName(String userName);

}
