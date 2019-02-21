package com.cooper.springbootsecurity.config;

import com.cooper.springbootsecurity.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/18
 * @describe
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       // auth.userDetailsService(userDetailsService()).passwordEncoder(new CustomPasswordEncoder());
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("forezp").password("123456").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN","USER").build());
        return manager;
    }
}
