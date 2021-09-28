package com.prueba.model.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prueba.model.service.UserDetailsServiceImpl;
import com.prueba.model.service.UsuarioServImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};
		

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/","/index").permitAll()
	      //  .antMatchers("/admin*").access("hasRole('ADMIN')")
	      //  .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/index")
                .permitAll()
                .defaultSuccessUrl("/views/dashboard")
                .failureUrl("/index?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/index?logout");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}