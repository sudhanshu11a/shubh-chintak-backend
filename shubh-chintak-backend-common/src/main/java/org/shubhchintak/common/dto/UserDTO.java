/**
 * 
 */
package org.shubhchintak.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.shubhchintak.common.enums.RoleEnum;

/**
 * @author sudhanshusharma
 *
 */
public class UserDTO extends BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String password;
	
	@NotEmpty
	private String username;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	private boolean enabled;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date dob;

	private String emailId;

	private String mobileNumber;

	private AddressDTO address;

	@NotEmpty
	private List<RoleEnum> roles;

	private UploadFileDTO profilePhoto;


	/**
	 * for making it model object
	 */
	public UserDTO() {

	}

	/**
	 *  Copy Constructor 
	 */
	public UserDTO(UserDTO userDTO) {
		super(userDTO.getId(), userDTO.getCreatedDate(), userDTO.getCreatedBy(), userDTO.getModifiedDate(), userDTO.getModifiedBy(), userDTO.getActive());
		this.password = userDTO.getPassword();
		this.username = userDTO.getUsername();
		this.accountNonExpired = userDTO.isAccountNonExpired();
		this.accountNonLocked = userDTO.isAccountNonLocked();
		this.credentialsNonExpired = userDTO.isCredentialsNonExpired();
		this.enabled = userDTO.isEnabled();
		this.firstName = userDTO.getFirstName();
		this.middleName = userDTO.getMiddleName();
		this.lastName = userDTO.getLastName();
		this.dob = userDTO.getDob();
		this.emailId = userDTO.getEmailId();
		this.mobileNumber = userDTO.getMobileNumber();
		this.address = userDTO.getAddress();
		this.roles = userDTO.getRoles();
		this.profilePhoto = userDTO.getProfilePhoto();
	}


	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param password
	 * @param username
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dob
	 * @param emailId
	 * @param mobileNumber
	 * @param address
	 * @param roles
	 * @param profilePhoto
	 */
	public UserDTO(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			String password, String username, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, String firstName, String middleName, String lastName,
			Date dob, String emailId, String mobileNumber, AddressDTO address, List<RoleEnum> roles,
			UploadFileDTO profilePhoto) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active);
		this.password = password;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.roles = roles;
		this.profilePhoto = profilePhoto;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}


	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	/**
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}


	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}


	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}


	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}


	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}


	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		this.address = address;
	}


	/**
	 * @return the roles
	 */
	public List<RoleEnum> getRoles() {
		return roles;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleEnum> roles) {
		this.roles = roles;
	}


	/**
	 * @return the profilePhoto
	 */
	public UploadFileDTO getProfilePhoto() {
		return profilePhoto;
	}


	/**
	 * @param profilePhoto the profilePhoto to set
	 */
	public void setProfilePhoto(UploadFileDTO profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

}
