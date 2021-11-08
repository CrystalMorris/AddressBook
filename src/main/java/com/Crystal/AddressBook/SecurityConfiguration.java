package com.Crystal.AddressBook;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity
                .authorizeRequests().antMatchers("/register").permitAll()
                .antMatchers(
                        "/users").hasRole("ADMIN").antMatchers("/addresses").hasAnyRole("ADMIN","USER")
                .anyRequest().fullyAuthenticated().and().httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication)
            throws Exception {


        // use jdbc authentication (for in memory authentication use authentication.inMemoryAuthentication())
        authentication.inMemoryAuthentication()
                //inMemoryAuthentication()
                .withUser("sparky")

                .password(passwordEncoder().encode("roadIslandPickle"))
             .roles("ADMIN","USER");
;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // specify we want the password hashed using bcrypt
        return new BCryptPasswordEncoder();
    }
}
