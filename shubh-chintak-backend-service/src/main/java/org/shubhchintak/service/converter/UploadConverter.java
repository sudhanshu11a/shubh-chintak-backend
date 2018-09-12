/**
 * 
 */
package org.shubhchintak.service.converter;

import org.shubhchintak.common.dto.UploadFileDTO;
import org.shubhchintak.persistence.entity.UploadFile;
import org.shubhchintak.service.converter.base.BaseConverter;
import org.springframework.stereotype.Component;

/**
 * @author sudhanshusharma
 *
 */
@Component
public final class UploadConverter implements BaseConverter<UploadFileDTO, UploadFile> {

	@Override
	public UploadFileDTO convertToDTO(UploadFile entity) {
		UploadFileDTO uploadFileDTO = null;
		if (entity != null) {
			uploadFileDTO = new UploadFileDTO(entity.getId(), entity.getCreatedDate(), entity.getCreatedBy(),
					entity.getModifiedDate(), entity.getModifiedBy(), entity.getActive(), null, entity.getFileName(),
					entity.getPath(), entity.getType());
		}
		return uploadFileDTO;
	}

	@Override
	public UploadFile convertToEntity(UploadFileDTO dto) {
		UploadFile uploadFile = null;
		Long organizationId =0l;
		if (dto != null) {
			if (dto.getId() != null) {
				uploadFile = new UploadFile(dto.getId(), dto.getCreatedDate(), dto.getCreatedBy(),
						dto.getModifiedDate(), dto.getModifiedBy(), dto.getActive(), organizationId, dto.getFileName(),
						dto.getPath(), dto.getType());
			} else {
				uploadFile = new UploadFile(dto.getFileName().trim(), dto.getPath().trim(), dto.getType().trim());
			}
		}
		return uploadFile;
	}

}
