/**
 * 
 */
package org.shubhchintak.constant;

/**
 * @author sudhanshusharma
 *
 */
public final class PageNameConstants {

	// Dashboard Page
	public static final String TILES_DASHBOARD = "tiles/dashboard";

	// user pages
	public static final String TILES_CREATE_NEW_USER_PAGE = "tiles/admin/user/createUser";
	public static final String TILES_ALL_USERS_LIST_PAGE = "tiles/admin/user/allUsers";
	public static final String TILES_USER_DETAILS_PAGE = "tiles/admin/user/userDetails";

	//role Pages
	public static final String TILES_CREATE_NEW_ROLE_PAGE = "tiles/admin/user/createUser";
	public static final String TILES_ALL_ROLE_LIST_PAGE = "tiles/admin/role/allRoleList";

	//login Pages
	public static final String SPRING_LOGIN_PAGE = "loginPage";
	
	public static final String EXCEPTION_PAGE = "exception_page";

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
