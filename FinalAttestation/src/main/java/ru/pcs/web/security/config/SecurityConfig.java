package ru.pcs.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/users**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/m*/**").authenticated()
                .antMatchers(HttpMethod.POST,"/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/a*/**").authenticated()
                .antMatchers("/sign_up").permitAll()
                .and()
                .formLogin()
                .loginPage("/sign_in")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/movies")
                .permitAll();
    }
}
