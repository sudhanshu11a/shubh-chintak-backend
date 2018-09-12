/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.ProjectDTO;
import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.persistence.entity.Project;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public final class ProjectConverter implements BaseConverter<ProjectDTO, Project>{

	@Autowired
	private UploadConverter uploadConverter;
	
	@Override
	public ProjectDTO convertToDTO(Project entity) {
		ProjectDTO projectDTO = null;
		if (entity != null) {
			UploadFile bannerImageEntity = null;
			UploadFileDTO logoImage = uploadConverter.convertToDTO(entity.getLogoImage());
			if (entity.getBannerImage() != null ) {
				bannerImageEntity = entity.getBannerImage();
			}
			UploadFileDTO bannerImage = uploadConverter.convertToDTO(bannerImageEntity);
			projectDTO = new ProjectDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), entity.getName(),
					entity.getDescription(), entity.getHeading(), entity.getDisplayDetails(), entity.getStartDate(),
					entity.getEndDate(), logoImage, bannerImage);
		}
		return projectDTO;
	}

	@Override
	public Project convertToEntity(ProjectDTO dto) {
		Project project = null;
		if (dto != null) {
			UploadFile logoImage = null;
			UploadFile bannerImage = null;
			if (dto.getId() != null) {
				project = new Project(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(), dto.getModifiedDate(),
						dto.getModifiedBy(), dto.getActive(), 0l, dto.getName(), dto.getDescription(), dto.getHeading(),
						dto.getDisplayDetails(), dto.getStartDate(), dto.getEndDate(), logoImage, bannerImage);
			} else {
				new Project(dto.getName(), dto.getDescription(), dto.getHeading(), dto.getDisplayDetails(),
						dto.getStartDate(), dto.getEndDate(), logoImage, bannerImage);
			}
		}
		return project;
	}

}
