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
import vn.com.osstech.uaa.model.mapper.AccountMapper;
import vn.com.osstech.uaa.model.reponse.RestResult;
import vn.com.osstech.uaa.model.request.UserRequest;
import vn.com.osstech.uaa.service.AccountRoleService;
import vn.com.osstech.uaa.service.AccountService;

/**
 * @author Truong Duong on 24/02/2020
 */

@RestController
@RequestMapping(ServicePath.ACCOUNT)
public class UserController {

  @Autowired
  AccountService accountService;

  @Autowired
  AccountRoleService accountRoleService;

  @Autowired
  AccountMapper accountMapper;

  @GetMapping(ServicePath.USER)
  public ResponseEntity findByAll() {
    RestResult result = new RestResult<>();
    result.ok(accountMapper.toListAccountDTO(accountService.findByAll()));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(ServicePath.USER_ID)
  public ResponseEntity findById(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    result.ok(accountMapper.toAccountDTO(accountService.findById(id)));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(ServicePath.USER_ROLE)
  public ResponseEntity findByRoles(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    result.ok(accountRoleService.findByAccount(id));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(ServicePath.USER)
  public ResponseEntity save(@RequestBody UserRequest userRequest) {
    RestResult result = new RestResult<>();
    result.ok(accountMapper.toAccountDTO(accountService.save(userRequest)));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping(ServicePath.USER_ID)
  public ResponseEntity delete(@PathVariable(value = "id") long id) {
    RestResult result = new RestResult<>();
    boolean temp = accountService.delete(id);
    if (temp) {
      result.ok();
    } else {
      result.fail();
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}