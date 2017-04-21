/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address", referencedColumnName = "id")
	private Address address;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_photo", referencedColumnName = "id")
	private UploadFile profilePhoto;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dob
	 * @param emailId
	 * @param mobileNumber
	 * @param address
	 * @param profilePhoto
	 */
	public UserDetails(String firstName, String middleName, String lastName, Date dob, String emailId,
			String mobileNumber, Address address, UploadFile profilePhoto) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.profilePhoto = profilePhoto;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organizationId
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dob
	 * @param emailId
	 * @param mobileNumber
	 * @param address
	 * @param profilePhoto
	 */
	public UserDetails(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String firstName, String middleName, String lastName, Date dob, String emailId,
			String mobileNumber, Address address, UploadFile profilePhoto) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.profilePhoto = profilePhoto;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UploadFile getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(UploadFile profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

}
