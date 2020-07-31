package vn.com.osstech.uaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@EnableCircuitBreaker
public class AuthServiceApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(AuthServiceApplication.class, args);
  }

  @Autowired
  private PasswordEncoder userPasswordEncoder;

  @Autowired
  private PasswordEncoder oauthClientPasswordEncoder;

  @Override
  public void run(String... args) throws Exception {
    String password = "password";
    System.out.println("userPasswordEncoder: "+userPasswordEncoder.encode(password));
    System.out.println("oauthClientPasswordEncoder: "+oauthClientPasswordEncoder.encode(password));
  }

}
