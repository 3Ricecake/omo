package org.student.omo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.student.omo.security.ApplicationAuthenticationProvider;
import org.student.omo.security.ApplicationSecurityContextRepository;
import org.student.omo.service.UserService;

/** Spring Security configuration. */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

  private final ApplicationAuthenticationProvider authenticationProvider;
  private final ApplicationSecurityContextRepository securityContextRepository;
  private final UserService userService;

  /**
   * Returns configured {@link WebSecurityConfigurerAdapter}.
   *
   * @return {@link WebSecurityConfigurerAdapter} bean.
   */
  @Bean
  public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
    return new WebSecurityConfigurerAdapter() {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http
          .httpBasic().disable()
          .formLogin().disable()
          .logout().disable()
          .csrf().disable()
          .authenticationProvider(authenticationProvider)

          .securityContext()
          .securityContextRepository(securityContextRepository)

          .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

          .and()
          .authorizeRequests()
          .antMatchers(HttpMethod.GET).permitAll()
          .antMatchers(
            "/api/users/register",
            "/api/users/sign/in",
            "/api/users/current"
          ).permitAll();
      }
    };
  }
}
