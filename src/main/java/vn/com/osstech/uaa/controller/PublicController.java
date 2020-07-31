package vn.com.osstech.uaa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.osstech.uaa.common.ServicePath;
import vn.com.osstech.uaa.model.reponse.RestResult;

/**
 * @author Truong Duong on 24/02/2020
 */

@RestController
@RequestMapping(ServicePath.PUBLIC)
public class PublicController {

  @GetMapping
  public ResponseEntity testPublic() {
    RestResult result = new RestResult<>();
    result.ok();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}