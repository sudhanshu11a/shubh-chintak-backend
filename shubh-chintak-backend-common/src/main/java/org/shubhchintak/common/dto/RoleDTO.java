/**
 * 
 */
package org.shubhchintak.common.dto;

import org.shubhchintak.common.enums.RoleEnum;

/**
 * @author sudhanshusharma
 *
 */
public class RoleDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267413300561228850L;

	private RoleEnum roleName;

	private String description;

	public RoleEnum getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
