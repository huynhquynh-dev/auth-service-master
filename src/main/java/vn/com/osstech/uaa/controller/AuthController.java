package vn.com.osstech.uaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.osstech.uaa.common.ServicePath;
import vn.com.osstech.uaa.model.reponse.RestResult;
import vn.com.osstech.uaa.model.request.AuthRequest;
import vn.com.osstech.uaa.service.AuthService;

/**
 * @author Truong Duong on 24/02/2020
 */

@RestController
@RequestMapping(ServicePath.AUTH)
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping(value = ServicePath.AUTH_LOGIN)
  public ResponseEntity login(@RequestBody AuthRequest authRequest) {
    RestResult result = new RestResult<>();
    result.fail();
    try {
      OAuth2AccessToken oAuth2AccessToken = authService.login(authRequest);
      if (oAuth2AccessToken == null && oAuth2AccessToken.getValue() != null) {
        result.fail();
      } else {
        result.ok(oAuth2AccessToken);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      result.fail();
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(value = ServicePath.AUTH_LOGOUT)
  public ResponseEntity logout(@RequestBody AuthRequest authRequest) {
    RestResult result = new RestResult<>();
    result.ok();
    authService.logout(authRequest);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}