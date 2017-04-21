/**
 * 
 */
package org.shubhchintak.service.convertor.base;

import java.util.List;

/**
 * @author sudhanshusharma
 *
 */
public interface BaseConvertor<DTO, E> {

	DTO entityToDTO(E entity); 

	E dtoToEntity(DTO dto);
	
	List<DTO> entityListToDTOList(List<E> entities); 

	List<E> dtoListToEntityList(List<DTO> dtos);
	
	
}
