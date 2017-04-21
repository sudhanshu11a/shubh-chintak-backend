/**
 * 
 */
package org.shubhchintak.service.convertor;

import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.persistence.entity.User;
import org.shubhchintak.service.convertor.base.BaseConvertor;

/**
 * @author sudhanshusharma
 *
 */
public class UserDTOConvertor implements BaseConvertor<UserDTO, User> {

	@Override
	public UserDTO entityToDTO(User e) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(e.getFirstName());
		return userDTO;
	}

	@Override
	public User DTOToEntity(UserDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

}