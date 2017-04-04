/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
//@Entity
//@Table(name = "sys_permission")
public class Permission extends BaseEntity{

	@Column(name = "name")
	private String name;
		
	@Column(name = "write_permission")
	private Boolean writePermission;
	
	@ManyToMany
	@JoinTable(name = "roles", 
		joinColumns = {@JoinColumn(name = "permission_id" , referencedColumnName = "id")} ,
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roles = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getWritePermission() {
		return writePermission;
	}

	public void setWritePermission(Boolean writePermission) {
		this.writePermission = writePermission;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
