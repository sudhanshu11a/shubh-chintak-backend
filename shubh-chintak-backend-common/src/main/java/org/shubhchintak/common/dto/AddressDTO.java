/**
 * 
 */
package org.shubhchintak.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sudhanshusharma
 *
 */
public class AddressDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5133983848331381248L;
	
	private String city;
	

	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param isActive
	 * @param organization
	 * @param city
	 */
	public AddressDTO(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active, String city) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active);
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
