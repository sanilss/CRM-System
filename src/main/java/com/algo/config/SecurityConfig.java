package com.algo.config;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.algo.filter.JwtAuthFilter;
import com.algo.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
@Autowired
private JwtAuthFilter authFilter;
	
	  @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	  
	  
	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      http.csrf((csrf) -> csrf.disable())
	              .authorizeHttpRequests((authorize) -> 
	                      authorize
	                      //1st request matcher /userInfo/new is for testing
	                      .requestMatchers("/users/authenticate","/usersInfo/new").permitAll()
	                      .requestMatchers("/distributer/**").hasAnyRole("ADMIN", "USERS")
	                      .requestMatchers("/masterAdmin/**").hasAnyRole("ADMIN", "USERS")
	                      .requestMatchers("/masterDistributer/**").hasAnyRole("ADMIN", "USERS")
	                      .requestMatchers("/roles/**").hasAnyRole("ADMIN", "USERS")
	                      .requestMatchers("/salesAdmin/**").hasAnyRole("ADMIN", "USERS")
	                              .anyRequest().authenticated()
	                       
	                             
	              )
	              
	              .sessionManagement((session) -> session
	                      .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	              .authenticationProvider(authenticationProvider())	
	              .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
	              
	              .httpBasic(httpSecurityHttpBasicConfigurer -> {})
	             // .httpBasic(Customizer.withDefaults())
	              .formLogin(formLogin->formLogin.disable())
	           
	              .exceptionHandling((exceptionHandling) ->
	                      exceptionHandling
	                              .accessDeniedHandler(accessDeniedHandler())
	                              .authenticationEntryPoint(authenticationEntryPoint())
	              );

	      return http.build();
	  }

	  @Bean
	  public AccessDeniedHandler accessDeniedHandler() {
	      return (httpServletRequest, httpServletResponse, e) -> {
	          httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
	          httpServletResponse.getWriter().write("Forbidden you don't have sufficient permission");
	      };
	  }

	  @Bean
	  public AuthenticationEntryPoint authenticationEntryPoint() {
	      return (httpServletRequest, httpServletResponse, e) -> {
	          httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
	          httpServletResponse.getWriter().write("Access Denied");
	      };
	  }

	  
    @Bean
    public UserDetailsService userDetailsService(){

//    	
//        UserDetails normalUserDetails = User.builder()
//                .username("sanil")
//                .password(bCryptPasswordEncoder().encode("sanil"))
//                .roles("USERS")
//                .build();
//
//        UserDetails adminUserDetails = User.builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(normalUserDetails, adminUserDetails);
    
    return new UserInfoUserDetailsService();
    }
    
    //////changes done for JWT testing////    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	return config.getAuthenticationManager();    
    	}
    
   
    
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }
  
      
}