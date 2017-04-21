/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "project_event")
public class ProjectEvent extends BaseEntity {

	@Column(name = "name", nullable=false)
	private String name;

	private String description;

	@Column(nullable = false)
	private String heading;

	@Column(name = "display_details", nullable = false)
	private String displayDetails;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="project" , referencedColumnName ="id", nullable=false)
	private Project project;

	@Column(name = "is_one_day_event", nullable=false)
	private Boolean oneDayEvent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = true)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = true)
	private Date endDate;

	@Column(nullable=true)
	private String location;

	@Column(name="meeting_point", nullable=true)
	private String meetingPoint;

	@ManyToOne
	@JoinColumn(name = "log_image", referencedColumnName = "id")
	private UploadFile logoImage;

	@OneToMany
	@JoinColumn(name="banner_images" , referencedColumnName="id")
	private List<UploadFile> bannerImage;

	
	public ProjectEvent() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param name
	 * @param description
	 * @param heading
	 * @param displayDetails
	 * @param project
	 * @param oneDayEvent
	 * @param startDate
	 * @param endDate
	 * @param location
	 * @param meetingPoint
	 * @param logoImage
	 * @param bannerImage
	 */
	public ProjectEvent(String name, String description, String heading, String displayDetails, Project project,
			Boolean oneDayEvent, Date startDate, Date endDate, String location, String meetingPoint,
			UploadFile logoImage, List<UploadFile> bannerImage) {
		super();
		this.name = name;
		this.description = description;
		this.heading = heading;
		this.displayDetails = displayDetails;
		this.project = project;
		this.oneDayEvent = oneDayEvent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.meetingPoint = meetingPoint;
		this.logoImage = logoImage;
		this.bannerImage = bannerImage;
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
	 * @param description
	 * @param heading
	 * @param displayDetails
	 * @param project
	 * @param oneDayEvent
	 * @param startDate
	 * @param endDate
	 * @param location
	 * @param meetingPoint
	 * @param logoImage
	 * @param bannerImage
	 */
	public ProjectEvent(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String name, String description, String heading, String displayDetails,
			Project project, Boolean oneDayEvent, Date startDate, Date endDate, String location, String meetingPoint,
			UploadFile logoImage, List<UploadFile> bannerImage) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.name = name;
		this.description = description;
		this.heading = heading;
		this.displayDetails = displayDetails;
		this.project = project;
		this.oneDayEvent = oneDayEvent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.meetingPoint = meetingPoint;
		this.logoImage = logoImage;
		this.bannerImage = bannerImage;
	}

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Boolean getOneDayEvent() {
		return oneDayEvent;
	}

	public void setOneDayEvent(Boolean oneDayEvent) {
		this.oneDayEvent = oneDayEvent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMeetingPoint() {
		return meetingPoint;
	}

	public void setMeetingPoint(String meetingPoint) {
		this.meetingPoint = meetingPoint;
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
