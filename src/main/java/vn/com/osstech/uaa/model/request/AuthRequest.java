package vn.com.osstech.uaa.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Truong Duong
 * @since : 28/02/2020, Fri.
 **/
@Getter
@Setter
@ToString
public class AuthRequest {

  private String username;
  private String password;
  private String grantType;
  private String clientId;
  private String clientSerect;
  private String token;

}