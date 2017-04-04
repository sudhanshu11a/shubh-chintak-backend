/**
 * 
 */
package org.shubhchintak.persistence.entity;

//import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.Table;

//import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
//@Entity
//@Table(name = "user_role")
public class UserRole //extends BaseEntity 
{

	@ManyToOne
	@JoinColumn(name="userId" , referencedColumnName="id")
	private User userId;

	@ManyToOne
	@JoinColumn(name="roleId", referencedColumnName="id")
	private Role roleId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

}
