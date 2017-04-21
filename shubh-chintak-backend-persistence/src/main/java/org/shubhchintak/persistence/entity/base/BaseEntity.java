/**
 * 
 */
package org.shubhchintak.persistence.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.shubhchintak.common.dto.UserPrincipal;
import org.shubhchintak.persistence.entity.Organization;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author sudhanshusharma
 *
 */
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The created date. */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	/** The created by. */
	@CreatedBy
	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	/** The modified date. */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = true)
	private Date modifiedDate;

	/** The modified by. */
	@LastModifiedBy
	@Column(name = "modified_by", nullable = true)
	private Long modifiedBy;

	@Column(name = "is_active", nullable = false)
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id", referencedColumnName = "id", updatable = false, insertable = false)
	private Organization organization;

	@Column(name = "organization_id", nullable = false, insertable = true, updatable = true)
	private Long organizationId;

	//@Version
	//private Long version;

	/**
	 * 
	 */
	public BaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 */
	public BaseEntity(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.active = active;
		this.organizationId = organizationId;
	}

	public void copy(BaseEntity copyEntity) {
		this.setId(copyEntity.getId());
		this.setCreatedBy(copyEntity.getCreatedBy());
		this.setCreatedDate(copyEntity.createdDate);
		this.setModifiedBy(copyEntity.getModifiedBy());
		this.setModifiedDate(copyEntity.getModifiedDate());

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the organizationId
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId
	 *            the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

//	/**
//	 * @return the version
//	 */
//	public Long getVersion() {
//		return version;
//	}
//
//	/**
//	 * @param version
//	 *            the version to set
//	 */
//	public void setVersion(Long version) {
//		this.version = version;
//	}

	@PrePersist
	public void prePersist() {
		// current user information
		UserPrincipal currentUserPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (currentUserPrincipal == null) {
			throw new NullPointerException("No current User Principal found in Auditing");
		}
		this.createdBy = currentUserPrincipal.getCurrentUserId();
		this.createdDate = new Date();
		this.organizationId = currentUserPrincipal.getOrganizationId();
		this.active = true;
		
	}

	@PreUpdate
	public void preUpdate() {
		// current user information
		UserPrincipal currentUserPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (currentUserPrincipal == null) {
			throw new NullPointerException("No current User Principal found in Auditing");
		}
		this.modifiedBy = currentUserPrincipal.getCurrentUserId();
		this.modifiedDate = new Date();
	}

}
