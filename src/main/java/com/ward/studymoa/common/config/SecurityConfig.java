package com.ward.studymoa.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter characterEncodingFilter =
                new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceEncoding(true);

        http.authorizeRequests()
                .antMatchers("/oauth2/**",
                        "/login/**",
                        "/css/**",
                        "/images/**",
                        "/js/**",
                        "/console/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .csrf().disable()
                .addFilterBefore(characterEncodingFilter, CsrfFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
