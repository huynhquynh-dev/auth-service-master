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
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.mapper.PermissionMapper;
import vn.com.osstech.uaa.model.mapper.RoleMapper;
import vn.com.osstech.uaa.model.reponse.RestResult;
import vn.com.osstech.uaa.model.reponse.RoleReponse;
import vn.com.osstech.uaa.model.request.RoleRequest;
import vn.com.osstech.uaa.service.RolePermissionService;
import vn.com.osstech.uaa.service.RoleService;

/**
 * @author : Truong Duong
 * @since : 06/03/2020, Fri.
 **/
@RestController
@RequestMapping(ServicePath.ACCOUNT)
public class RoleController {

  @Autowired
  RoleService roleService;

  @Autowired
  RolePermissionService rolePermissionService;

  @Autowired
  RoleMapper roleMapper;

  @Autowired
  PermissionMapper permissionMapper;

  @GetMapping(ServicePath.ROLE)
  public ResponseEntity findByAll() {
    RestResult result = new RestResult<>();
    result.ok(roleMapper.toListRoleDTO(roleService.findByAll()));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(ServicePath.ROLE_ID)
  public ResponseEntity findById(@PathVariable("id") long id) {
    RestResult result = new RestResult<>();

    Role role = roleService.findById(id);
    if (role != null) {
      RoleReponse roleReponse = roleMapper.toRoleDTO(role);
      roleReponse.setPermissions(permissionMapper.toListRolePermissionDTO(role.getPermissions()));
      result.ok(roleReponse);
    } else {
      result.fail();
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(ServicePath.ROLE_PERMISSION)
  public ResponseEntity findByPermissions(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    result.ok(rolePermissionService.findByRole(id));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(ServicePath.ROLE)
  public ResponseEntity save(@RequestBody RoleRequest roleRequest) {
    RestResult result = new RestResult<>();
    result.ok(roleMapper.toRoleDTO(roleService.save(roleRequest)));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping(ServicePath.ROLE_ID)
  public ResponseEntity delete(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    boolean temp = roleService.delete(id);
    if (temp) {
      result.ok();
    } else {
      result.fail();
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
