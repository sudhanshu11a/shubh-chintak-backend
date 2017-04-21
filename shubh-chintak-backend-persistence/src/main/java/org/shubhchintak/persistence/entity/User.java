/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role_mapping", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	@Column(name = "account_non_Expired", nullable = false)
	private Boolean accountNonExpired;

	@Column(name = "account_non_locked", nullable = false)
	private Boolean accountNonLocked;

	@Column(name = "credentials_non_expired", nullable = false)
	private Boolean credentialsNonExpired;

	@Column(name = "enable", nullable = false)
	private Boolean enabled;

	/**
	 * orphanRemoval is an entirely ORM-specific thing. It marks "child" entity
	 * to be removed when it's no longer referenced from the "parent" entity,
	 * e.g. when you remove the child entity from the corresponding collection
	 * of the parent entity.
	 * 
	 * ON DELETE CASCADE is a database-specific thing, it deletes the "child"
	 * row in the database when the "parent" row is deleted.
	 * 
	 * JPA Cascade Types
	 * 
	 * CascadeType.PERSIST : means that save() or persist() operations cascade
	 * to related entities.
	 * 
	 * CascadeType.MERGE : means that related entities are merged when the
	 * owning entity is merged.
	 * 
	 * CascadeType.REFRESH : does the same thing for the refresh() operation.
	 * 
	 * CascadeType.REMOVE : removes all related entities association with this
	 * setting when the owning entity is deleted.
	 * 
	 * CascadeType.DETACH : detaches all related entities if a “manual detach”
	 * occurs. CascadeType.ALL : is shorthand for all of the above cascade
	 * operations.
	 * 
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_details", nullable = false)
	private UserDetails userDetails;

	public User() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param userName
	 * @param password
	 * @param roles
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 * @param userDetails
	 */
	public User(String userName, String password, Set<Role> roles,  UserDetails userDetails, Boolean accountNonExpired, Boolean accountNonLocked,
			Boolean credentialsNonExpired, Boolean enabled) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.userDetails = userDetails;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 * @param userName
	 * @param password
	 * @param roles
	 * @param userDetails
	 */
	public User(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String userName, String password, Set<Role> roles, UserDetails userDetails,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.userDetails = userDetails;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails
	 *            the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the accountNonExpired
	 */
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @return the accountNonLocked
	 */
	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @return the credentialsNonExpired
	 */
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
