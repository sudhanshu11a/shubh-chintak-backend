/**
 * 
 */
package org.shubhchintak.common.dto;

import java.io.Serializable;
import java.util.Date;

import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.common.dto.TenantDTO;

/**
 * @author sudhanshusharma
 *
 */
public abstract class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5400906851305224533L;

	/** The id. */
	private Long id;

	/** The created date. */
	private Date createdDate;

	/** The created by. */
	private Long createdBy;

	/** The modified date. */
	private Date modifiedDate;

	/** The modified by. */
	private Long modifiedBy;

	/** The soft delete. */
	private Boolean active;

	//private long organizationId;

	/**
	 * 
	 */
	public BaseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param isActive
	 * @param organization
	 */
	public BaseDTO(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.active = active;
		
		//this.organization = organization;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the created date.
	 * 
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 * 
	 * @param createdDate
	 *            the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the created by.
	 * 
	 * @return the created by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 * 
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the modified date.
	 * 
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 * 
	 * @param modifiedDate
	 *            the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Gets the modified by.
	 * 
	 * @return the modified by
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 * 
	 * @param modifiedBy
	 *            the new modified by
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

//	/**
//	 * @return the organizationId
//	 */
//	public long getOrganizationId() {
//		return organizationId;
//	}
//
//	/**
//	 * @param organizationId the organizationId to set
//	 */
//	public void setOrganizationId(long organizationId) {
//		this.organizationId = organizationId;
//	}



}
