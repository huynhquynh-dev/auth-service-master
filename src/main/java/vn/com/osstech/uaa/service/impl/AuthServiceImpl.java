package vn.com.osstech.uaa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import vn.com.osstech.uaa.model.request.AuthRequest;
import vn.com.osstech.uaa.service.AuthService;
import vn.com.osstech.uaa.service.OAuth2Service;

/**
 * @author : Truong Duong
 * @since : 28/02/2020, Fri.
 **/
@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  OAuth2Service oAuth2Service;

  @Override
  public OAuth2AccessToken login(AuthRequest authRequest) {
    switch (authRequest.getGrantType()) {
      case "password":
        return oAuth2Service.accessToken(authRequest);
      case "refresh_token":
        return oAuth2Service.refreshToken(authRequest);
      default:
        return null;
    }
  }

  @Override
  public void logout(AuthRequest authRequest) {
    oAuth2Service.removeToken(authRequest.getToken());
  }
}
