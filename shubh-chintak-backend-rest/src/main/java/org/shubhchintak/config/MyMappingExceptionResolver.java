/**
 * 
 */
package org.shubhchintak.config;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author sudhanshusharma
 *
 */
public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {

	/**
	 * 
	 */
	public MyMappingExceptionResolver() {
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");
		mappings.setProperty("InvalidCreditCardException", "creditCardError");
		mappings.setProperty("defaultErrorView", "error");

		setExceptionMappings(mappings); // None by default
		setDefaultErrorView("error"); // No default
		setExceptionAttribute("ex"); // Default is "exception"
		setWarnLogCategory("example.MvcLogger"); // No default
	}

	@Override
	public String buildLogMessage(Exception e, HttpServletRequest req) {
		return "MVC exception: " + e.getLocalizedMessage();
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
			Exception ex) {
		// Call super method to get the ModelAndView
		ModelAndView mav = super.doResolveException(req, resp, handler, ex);

		// Make the full URL available to the view - note ModelAndView uses
		// addObject() but Model uses addAttribute(). They work the same.
		mav.addObject("url", req.getRequestURL());
		return mav;
	}
}
