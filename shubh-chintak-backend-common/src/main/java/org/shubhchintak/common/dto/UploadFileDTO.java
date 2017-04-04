/**
 * 
 */
package org.shubhchintak.common.dto;


/**
 * @author sudhanshusharma
 *
 */
public class UploadFileDTO extends BaseDTO{

	private String fileName;

	private String path;

	
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


}
