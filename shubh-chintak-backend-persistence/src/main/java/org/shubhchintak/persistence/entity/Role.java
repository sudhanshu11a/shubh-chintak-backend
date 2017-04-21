/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.shubhchintak.common.enums.RoleEnum;
import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {

	@Column(name = "role_name")
	@Enumerated(EnumType.STRING)
	private RoleEnum roleName;

	@Column(name = "description")
	private String description;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<Menu> menus = new HashSet<>();

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param roleName
	 * @param description
	 * @param users
	 * @param menus
	 */
	public Role(RoleEnum roleName, String description, Set<User> users, Set<Menu> menus) {
		super();
		this.roleName = roleName;
		this.description = description;
		this.users = users;
		this.menus = menus;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 * @param roleName
	 * @param description
	 * @param users
	 * @param menus
	 */
	public Role(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, RoleEnum roleName, String description, Set<User> users, Set<Menu> menus) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.roleName = roleName;
		this.description = description;
		this.users = users;
		this.menus = menus;
	}

	/**
	 * @return the roleName
	 */
	public RoleEnum getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	
	
}
