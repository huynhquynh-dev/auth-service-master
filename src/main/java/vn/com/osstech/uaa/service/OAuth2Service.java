package vn.com.osstech.uaa.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import vn.com.osstech.uaa.model.request.AuthRequest;

/**
 * @author : Truong Duong
 * @since : 29/02/2020, Sat.
 **/
public interface OAuth2Service {

  public OAuth2AccessToken accessToken(AuthRequest authRequest);

  public OAuth2AccessToken refreshToken(AuthRequest authRequest);

  public void removeToken(String token);

}
