/**
 * 
 */
package org.shubhchintak.persistence.config;

import org.shubhchintak.common.dto.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author sudhanshusharma
 *
 */
public class CurrentUserAuditorAware implements AuditorAware<Long> {

	/* (non-Javadoc)
	 * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
	 */
	@Override
	public Long getCurrentAuditor() {
		
		//current user information
		UserPrincipal currentUserPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(currentUserPrincipal==null){
			throw new NullPointerException("No current User Principal found in Auditing");
		}
		return currentUserPrincipal.getCurrentUserId();
	}

}
