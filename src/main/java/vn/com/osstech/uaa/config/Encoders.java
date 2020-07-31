package vn.com.osstech.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : Truong Duong
 * @since : 08/03/2020, Sun.
 **/
@Configuration
public class Encoders {

  @Bean
  public PasswordEncoder oauthClientPasswordEncoder() {
    return new BCryptPasswordEncoder(4);
  }

  @Bean
  public PasswordEncoder userPasswordEncoder() {
    return new BCryptPasswordEncoder(8);
  }

}
