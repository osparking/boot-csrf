package space.bum.spring_boot.config;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  CsrfTokenRepository csrfTokenRepository() {
    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    repository.setHeaderName("X-XSRF-TOKEN");
    return repository;
  }

  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(req -> req.requestMatchers("/example/form")
        .permitAll().anyRequest().authenticated())
        .formLogin(withDefaults())
        .csrf(csrf -> csrf
            .csrfTokenRepository(csrfTokenRepository()));
  }
}