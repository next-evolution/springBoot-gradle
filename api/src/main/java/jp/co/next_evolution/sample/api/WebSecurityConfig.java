package jp.co.next_evolution.sample.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // spring-security認証は後回し
        http.authorizeRequests().anyRequest().permitAll();

        // spring-security CSRF無効化する
        http.csrf().disable();
    }

}
