/**
 * 
 */
package org.shubhchintak.common.dto;

import java.util.Date;

/**
 * @author sudhanshusharma
 *
 */
public class OrganizationDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8656673722402691004L;
	
	private String name;

	public OrganizationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Copy Constructor 
	 */
	public OrganizationDTO(OrganizationDTO organizationDTO) {
		super(organizationDTO.getId(), organizationDTO.getCreatedDate(), organizationDTO.getCreatedBy(), organizationDTO.getModifiedDate(), organizationDTO.getModifiedBy(), organizationDTO.getActive());
		this.name = organizationDTO.getName();
	}



	/**
	 * @param id
	 * @param name
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param isActive
	 */
	public OrganizationDTO(long id, String name, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy,
			Boolean active) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active);
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
