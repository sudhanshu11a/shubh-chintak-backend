/**
 * 
 */
package org.shubhchintak.constant;

/**
 * @author sudhanshusharma
 * 
 *         <P>
 * 		All members of this class are immutable.
 *
 */
public final class ApplicationConstants {

	/** System property - <tt>file.separator</tt> */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	/** System property - <tt>path.separator</tt> */
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");

	/** Opposite of {@link #FAILURE}. */
	public static final boolean SUCCESS = true;

	/**
	 * Useful for {@link String} operations, which return an index of
	 * <tt>-1</tt> when an item is not found.
	 */
	public static final int NOT_FOUND = -1;

	public ApplicationConstants() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}
}
