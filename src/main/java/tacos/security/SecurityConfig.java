package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tacos.User;
import tacos.data.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository) {
    	
    	return username -> {
    		User user = userRepository.findByUsername(username);
    		if(user!=null)
    			return user;
    		throw new UsernameNotFoundException("User '"+username+"' not found");
    	};
    	
    }

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	return http
    			.authorizeRequests()
    				.antMatchers("/design","/orders").access("hasRole('USER')")
    				.antMatchers("/","/**").access("permitAll()")
    			.and()
    				.formLogin()
    					.loginPage("/login")
    			.and()
    			.build();
    }
    
}
