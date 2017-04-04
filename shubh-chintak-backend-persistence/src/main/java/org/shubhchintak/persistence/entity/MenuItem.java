/**
 * 
 */
package org.shubhchintak.persistence.entity;

import javax.persistence.Entity;
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

	private String label;

	private String link;

	@ManyToOne
	@JoinColumn(name = "parent", referencedColumnName = "id", nullable = false, insertable = false)
	private Menu parent;

	
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
