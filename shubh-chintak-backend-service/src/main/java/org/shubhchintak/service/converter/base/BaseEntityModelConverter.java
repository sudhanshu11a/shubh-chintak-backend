/**
 * 
 */
package org.shubhchintak.service.converter.base;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sudhanshusharma
 *
 */
public interface BaseEntityModelConverter<DTO, E> {

	DTO entityToDTO(E entity);

	E dtoToEntity(DTO dto);

	default List<DTO> entityListToDTOLists(List<E> entities) {
		return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	default List<E> dtoListToEntityLists(List<DTO> dtos) {
		return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
