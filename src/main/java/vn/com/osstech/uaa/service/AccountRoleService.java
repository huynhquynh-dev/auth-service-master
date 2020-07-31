package vn.com.osstech.uaa.service;

import java.util.List;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.reponse.RoleReponse;

/**
 * @author : Truong Duong
 * @since : 11/03/2020, Wed.
 **/
public interface AccountRoleService {

  List<RoleReponse> findByAccount(long accountId);

  AccountRole save(Account account, long roleId);

}
