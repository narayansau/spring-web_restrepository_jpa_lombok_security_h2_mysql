package com.example.web_restrepository_jpa_lombok_security_h2_mysql.Security_Configuration;

import com.example.web_restrepository_jpa_lombok_security_h2_mysql.Repository.PersonRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.naming.AuthenticationException;

@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter{

private PersonRepository personRepository;

    public DirectorySecurityConfig(PersonRepository personRepository) {
        this.personRepository=personRepository;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http . authorizeRequests() .antMatchers( "/**" ) .
                hasRole( "ADMIN" ).and().httpBasic();
    }


}
