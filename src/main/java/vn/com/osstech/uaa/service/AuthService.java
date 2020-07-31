package vn.com.osstech.uaa.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import vn.com.osstech.uaa.model.request.AuthRequest;

/**
 * @author : Truong Duong
 * @since : 28/02/2020, Fri.
 **/
public interface AuthService {

  public OAuth2AccessToken login(AuthRequest authRequest);

  public void logout(AuthRequest authRequest);

}