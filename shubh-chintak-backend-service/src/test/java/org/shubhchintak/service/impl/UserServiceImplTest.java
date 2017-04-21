/**
 * 
 */
package org.shubhchintak.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.shubhchintak.api.service.UserService;
import org.shubhchintak.common.dto.UserDTO;
import org.shubhchintak.service.impl.UserServiceImpl;

/**
 * @author sudhanshusharma
 *
 */
public class UserServiceImplTest {
	
	
	private UserService userService;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		userService = null;
	}

	/**
	 * Test method for {@link org.shubhchintak.service.impl.UserServiceImpl#getUserByName(java.lang.String, long, long)}.
	 */
	@Test
	public final void testGetUserByName() {
		//UserDTO actual = userService.getUserByName("sudhanshu", 1, 1);
		//UserDTO expected = new UserDTO();
		//expected.setUserName("sudhanshu");
		
		//assertEquals(expected.getName(), actual.getName());
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.shubhchintak.service.impl.UserServiceImpl#loadUserByUsername(java.lang.String)}.
	 */
	@Test
	public final void testLoadUserByUsername() {
		//fail("Not yet implemented"); // TODO
		
		
	}

}
