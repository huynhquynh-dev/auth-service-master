package vn.com.osstech.uaa.service;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.request.UserRequest;

/**
 * @author : Truong Duong
 * @since : 03/03/2020, Tue.
 **/
public interface AccountService {

  List<Account> findByAll();

  Account findById(long accountId);

  Account save(UserRequest userRequest);

  boolean delete(long accountId);

}
