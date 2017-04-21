/**
 * 
 */
package org.shubhchintak.constant;

/**
 * @author sudhanshusharma
 *
 */
public final class PageNameConstants {

	public static final String TILES_DASHBOARD = "tiles/dashboard";
	
	
	public static final String TILES_CREATE_NEW_USER_PAGE = "tiles/admin/user/createUser";
	
	public static final String TILES_ALL_USERS_LIST = "tiles/admin/user/allUserList";
	public static final String TILES_USER_DETAILS = "tiles/admin/user/userDetails";
	
	
	public static final String SPRING_LOGIN_PAGE = "loginPage";
	
	/**
	 * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
	 * and so on. Thus, the caller should be prevented from constructing objects
	 * of this class, by declaring this private constructor.
	 */
	private PageNameConstants() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}

}
