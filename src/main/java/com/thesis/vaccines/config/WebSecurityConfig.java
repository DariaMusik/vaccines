package com.thesis.vaccines.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home","/home-en","/home-pl",
                            "/registration", "/registration-en","/registration-pl",
                            "/login","/login-en","/login-pl","/symptom-en",
                            "/symptom-pl", "/symptomAge-en", "/symptomAge-pl",
                            "/symptomGroupAge-en", "/symptomGroupAge-pl",
                            "/symptomVaccines-en","/symptomVaccines-pl",
                            "/symptomVaxGroup-en","/symptomVaxGroup-pl",
                            "/symptomAgeDeath-en","/symptomAgeDeath-pl",
                            "/css/**","/img/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("Select username, password, active from user where username=?")
                .authoritiesByUsernameQuery("Select u.username, ur.roles from user u inner join user_role ur on u.id = ur.user_id where username=?");
    }
}
