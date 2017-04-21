/**
 * 
 */
package org.shubhchintak.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.shubhchintak.persistence.entity.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "file_upload")
public class UploadFile extends BaseEntity {

	@Column(name = "name")
	private String fileName;

	@Column(name = "path")
	private String path;

	@Column(name = "type")
	private String type;

	/**
	 * Constructor for loading JPA objects
	 */
	public UploadFile() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * For new objects creation
	 * 
	 * @param fileName
	 * @param path
	 * @param type
	 */
	public UploadFile(String fileName, String path, String type) {
		super();
		this.fileName = fileName;
		this.path = path;
		this.type = type;
	}



	/**
	 * @param id
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 * @param organization
	 * @param fileName
	 * @param path
	 * @param type
	 */
	public UploadFile(Long id, Date createdDate, Long createdBy, Date modifiedDate, Long modifiedBy, Boolean active,
			Long organizationId, String fileName, String path, String type) {
		super(id, createdDate, createdBy, modifiedDate, modifiedBy, active, organizationId);
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
