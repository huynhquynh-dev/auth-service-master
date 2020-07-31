package vn.com.osstech.uaa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.osstech.uaa.model.entity.Account;
import vn.com.osstech.uaa.model.entity.AccountRole;
import vn.com.osstech.uaa.model.entity.AccountRoleId;
import vn.com.osstech.uaa.model.entity.Role;
import vn.com.osstech.uaa.model.reponse.RoleReponse;
import vn.com.osstech.uaa.repository.AccountRoleRepository;
import vn.com.osstech.uaa.service.AccountRoleService;

/**
 * @author : Truong Duong
 * @since : 11/03/2020, Wed.
 **/
@Service
public class AccountRoleServiceImpl implements AccountRoleService {

  @Autowired
  AccountRoleRepository accountRoleRepository;

  @Override
  public List<RoleReponse> findByAccount(long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return accountRoleRepository.findByAccount(account);
  }

  @Override
  public AccountRole save(Account account, long roleId) {
    Role role = new Role();
    role.setId(roleId);

    accountRoleRepository.deleteByAccount(account);

    AccountRoleId accountRoleId = new AccountRoleId();
    accountRoleId.setAccountId(account.getId());
    accountRoleId.setRoleId(roleId);

    AccountRole accountRole = new AccountRole();
    accountRole.setId(accountRoleId);
    accountRole.setAccount(account);
    accountRole.setRole(role);
    accountRole.setEnabled(true);
    return accountRoleRepository.save(accountRole);
  }

}
