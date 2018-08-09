/**
 * 
 */
package org.shubhchintak.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("/message")
public class HelloService {

	@RequestMapping("/hello")
	public String getMessage() {
	return "Hello";	
	}
}
