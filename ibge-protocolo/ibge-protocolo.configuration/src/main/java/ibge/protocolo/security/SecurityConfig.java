package ibge.protocolo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	
	
	@Bean
	public PasswordEncoder encoder() { return new BCryptPasswordEncoder();} 

	
	
	private static final String[] AUTH = { "/v2/api-docs", "/swagger-resources", "/swagger-resources/**",
			"/configuration/ui", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**",
			"/swagger-ui/**" };

	private static final String[] AUTH_WHITELIST = {
	        // -- Swagger UI v2
	        "/v2/api-docs",
	        "v2/api-docs",
	        "/swagger-resources",
	        "swagger-resources",
	        "/swagger-resources/**",
	        "swagger-resources/**",
	        "/configuration/ui",
	        "configuration/ui",
	        "/configuration/security",
	        "configuration/security",
	        "/swagger-ui.html",
	        "swagger-ui.html",
	        "webjars/**",
	        // -- Swagger UI v3
	        "/v3/api-docs/**",
	        "v3/api-docs/**",
	        "/swagger-ui/**",
	        "swagger-ui/**",
	        // CSA Controllers
	        "/csa/api/token",
	        // Actuators
	        "/actuator/**",
	        "/health/**"
	};
	
	
	@Value("${app.user}")
	private String userName;
	
	@Value("${app.pass}")
	private String pass;
	
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
								.username(userName)
								.password(encoder().encode(pass))
								.roles("USER")
								.build();
		
		return new InMemoryUserDetailsManager(user);
								
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity
	    .csrf().disable()
	    .cors().and()
	            .authorizeHttpRequests((requests) -> requests
	                    .requestMatchers( new AntPathRequestMatcher("swagger-ui/**")).permitAll()
	                    .requestMatchers( new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
	                    .requestMatchers( new AntPathRequestMatcher("v3/api-docs/**")).permitAll()
	                    .requestMatchers( new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
	                    .anyRequest().authenticated())
	            .httpBasic(Customizer.withDefaults());
	    
	    return httpSecurity.build();
	}
}
