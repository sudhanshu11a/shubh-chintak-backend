/**
 * 
 */
package org.shubhchintak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * for scanning service classes
 * 
 * 
 * 
 * @author sudhanshusharma
 */
//@Configuration
@ComponentScan({ "org.shubhchintak.service.impl" })
public class SpringRootConfig {

}
