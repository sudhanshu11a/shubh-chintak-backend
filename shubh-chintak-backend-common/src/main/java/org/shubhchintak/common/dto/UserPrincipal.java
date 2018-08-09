/**
 * 
 */
package org.shubhchintak.common.dto;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shubhchintak.common.enums.RoleEnum;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author sudhanshusharma
 *
 */
public final class UserPrincipal implements UserDetails, CredentialsContainer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370042818989549666L;

	private final UserDTO userDTO;

	private final OrganizationDTO organizationDTO;
	
	public String getName(){
		return userDTO.getFirstName()+
			userDTO.getMiddleName()!=null?userDTO.getMiddleName()+" ":""+
			userDTO.getMiddleName();
	}
	
	public UserPrincipal() {
		userDTO = null;
		organizationDTO = null;
	}

	public UserPrincipal(UserDTO userDTO, OrganizationDTO organizationDTO) {
		checkNull(userDTO, organizationDTO);
		this.userDTO = userDTO;
		this.organizationDTO = organizationDTO;
	}

	private void checkNull(UserDTO userDTO, OrganizationDTO organizationDTO) {
		if (userDTO == null || organizationDTO == null) {
			throw new IllegalArgumentException();
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (RoleEnum role : userDTO.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		return authorities;
	}

	public String getPassword() {
		return userDTO.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return userDTO.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return userDTO.isAccountNonExpired();
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return userDTO.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return userDTO.isCredentialsNonExpired();
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return userDTO.isEnabled();
	}

//	/**
//	 * @return the userDTO
//	 */
//	public UserDTO getUserDTO() {
//		return new UserDTO(userDTO);
//	}
	
	public long getCurrentUserId(){
		return userDTO.getId();
	}
	
	public long getOrganizationId(){
		return organizationDTO.getId();
	}

//	/**
//	 * @return the organizationDTO
//	 */
//	public OrganizationDTO getOrganizationDTO() {
//		return new OrganizationDTO(organizationDTO);
//	}

	@Override
	public void eraseCredentials() {
		userDTO.setPassword(null);
		
	}

}
