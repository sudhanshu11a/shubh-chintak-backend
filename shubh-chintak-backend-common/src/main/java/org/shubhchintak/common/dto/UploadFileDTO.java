/**
 * 
 */
package org.shubhchintak.common.dto;

import java.util.Date;

/**
 * @author sudhanshusharma
 *
 */
public class UploadFileDTO extends BaseDTO{

	private String fileName;

	private String path;
	
	private String type;

	
	
	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param isActive
	 * @param organization
	 * @param fileName
	 * @param path
	 * @param type
	 */
	public UploadFileDTO(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy,
			Boolean isActive, OrganizationDTO organization, String fileName, String path, String type) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, isActive);
		this.fileName = fileName;
		this.path = path;
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
