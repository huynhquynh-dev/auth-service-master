package vn.com.osstech.uaa.model.reponse;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Truong Duong
 * @since : 28/02/2020, Fri.
 **/
@Getter
@Setter
public class AuthReponse {

  private String accessToken;
  private String refreshToken;
  private String tokenType;
  private long expiresIn;

}
