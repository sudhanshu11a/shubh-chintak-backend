/**
 * 
 */
package org.shubhchintak.config;

import org.shubhchintak.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @author sudhanshusharma
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);// .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.authorizeRequests().antMatchers("/welcome/*").access("hasRole('ADMIN')")
				//
				.and().formLogin().loginPage("/loginPage").defaultSuccessUrl("/welcome/home")
				.failureUrl("/loginPage?login_error=1")
				//
				.and().csrf().csrfTokenRepository(csrfTokenRepository());
	}

	// @Override
	private void configureDummy(HttpSecurity http) throws Exception {
		http
				// Configures form login
				.formLogin().loginPage("/login").loginProcessingUrl("/login/authenticate")
				.failureUrl("/login?error=bad_credentials")
				// Configures the logout function
				.and().logout().deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/login")
				// Configures url based authorization
				.and().authorizeRequests()
				// Anyone can access the urls
				.antMatchers("/auth/**", "/login", "/signup/**", "/user/register/**").permitAll()
				// The rest of the our application is protected.
				.antMatchers("/**").hasRole("USER");
		// Adds the SocialAuthenticationFilter to Spring Security's
		// filter chain.
		// .and().apply(new SpringSocialConfigurer());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setSessionAttributeName("_csrf");
		return repository;
	}

}
