/**
 * 
 */
package org.shubhchintak.common.dto;

import java.util.Date;

import org.shubhchintak.common.dto.OrganizationDTO;
import org.shubhchintak.common.dto.TenantDTO;

/**
 * @author sudhanshusharma
 *
 */
public abstract class BaseDTO {

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

	private Boolean isActive;

	private TenantDTO tenant;

	private OrganizationDTO organization;

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TenantDTO getTenantDTOId() {
		return tenant;
	}

	public void setTenantDTOId(TenantDTO tenant) {
		this.tenant = tenant;
	}

	public OrganizationDTO getOrganizationId() {
		return organization;
	}

	public void setOrganizationId(OrganizationDTO organization) {
		this.organization = organization;
	}
	
}

