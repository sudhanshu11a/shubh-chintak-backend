/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "sys_menu")
public class Menu extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(nullable = false)
	private String label;

	@Column(nullable = false)
	private String link;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_image", referencedColumnName = "id")
	private UploadFile logoImage;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "menu_role_mapping", joinColumns = {
			@JoinColumn(name = "menu_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<>();

	public Menu() {
	}
	
	

	/**
	 * @param name
	 * @param label
	 * @param link
	 * @param description
	 * @param logoImage
	 * @param roles
	 */
	public Menu(String name, String label, String link, String description, UploadFile logoImage, Set<Role> roles) {
		super();
		this.name = name;
		this.label = label;
		this.link = link;
		this.description = description;
		this.logoImage = logoImage;
		this.roles = roles;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 * @param name
	 * @param label
	 * @param link
	 * @param description
	 * @param logoImage
	 * @param roles
	 */
	public Menu(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String name, String label, String link, String description, UploadFile logoImage,
			Set<Role> roles) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.name = name;
		this.label = label;
		this.link = link;
		this.description = description;
		this.logoImage = logoImage;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UploadFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(UploadFile logoImage) {
		this.logoImage = logoImage;
	}

}
