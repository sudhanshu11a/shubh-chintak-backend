/**
 * 
 */
package org.shubhchintak.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author sudhanshusharma
 *
 */
//@Configuration
//@EnableJpaAuditing(auditorAwareRef = "CurrentUserAuditorAware")
public class AuditingConfiguration {

	
	@Bean
	public AuditorAware<Long> getSpringJpaAuditing(){
		return new CurrentUserAuditorAware();
	}
}
