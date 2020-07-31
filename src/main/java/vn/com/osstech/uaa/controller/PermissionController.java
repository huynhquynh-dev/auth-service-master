package vn.com.osstech.uaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.osstech.uaa.common.ServicePath;
import vn.com.osstech.uaa.model.mapper.PermissionMapper;
import vn.com.osstech.uaa.model.reponse.RestResult;
import vn.com.osstech.uaa.model.request.PermissionRequest;
import vn.com.osstech.uaa.service.PermissionService;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@RestController
@RequestMapping(ServicePath.ACCOUNT)
public class PermissionController {

  @Autowired
  PermissionService permissionService;

  @Autowired
  PermissionMapper permissionMapper;

  @GetMapping(ServicePath.PERMISSION)
  public ResponseEntity findByAll() {
    RestResult result = new RestResult<>();
    result.ok(permissionMapper.toListPermissionDTO(permissionService.findByAll()));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(ServicePath.PERMISSION)
  public ResponseEntity save(@RequestBody PermissionRequest permissionRequest) {
    RestResult result = new RestResult<>();
    result.ok(permissionMapper.toPermissionDTO(permissionService.save(permissionRequest)));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping(ServicePath.PERMISSION_ID)
  public ResponseEntity delete(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    boolean temp = permissionService.delete(id);
    if (temp) {
      result.ok();
    } else {
      result.fail();
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
