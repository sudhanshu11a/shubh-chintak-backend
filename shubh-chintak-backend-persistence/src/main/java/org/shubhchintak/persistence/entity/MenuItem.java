/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "sys_menu_item")
public class MenuItem extends BaseEntity {

	@Column(name = "label" , nullable= false)
	private String label;

	@Column(name = "link" , nullable = false)
	private String link;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)
	private Menu parent;

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param label
	 * @param link
	 * @param parent
	 */
	public MenuItem(String label, String link, Menu parent) {
		super();
		this.label = label;
		this.link = link;
		this.parent = parent;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 * @param label
	 * @param link
	 * @param parent
	 */
	public MenuItem(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String label, String link, Menu parent) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.label = label;
		this.link = link;
		this.parent = parent;
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

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

}
