/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	private String name;

	private String description;

	private String heading;

	@Column(name = "display_details")
	private String displayDetails;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = true)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = true)
	private Date endDate;

	@ManyToOne
	@JoinColumn(name="log_image" , referencedColumnName="id")
	private UploadFile logoImage;

	@OneToMany
	@JoinColumn(name="banner_images" , referencedColumnName="id")
	private List<UploadFile> bannerImage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDisplayDetails() {
		return displayDetails;
	}

	public void setDisplayDetails(String displayDetails) {
		this.displayDetails = displayDetails;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UploadFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(UploadFile logoImage) {
		this.logoImage = logoImage;
	}

	public List<UploadFile> getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(List<UploadFile> bannerImage) {
		this.bannerImage = bannerImage;
	}

	

	
}
